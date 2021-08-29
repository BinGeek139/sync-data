package com.vnpt.eoffice.controller.api;

import com.vnpt.eoffice.config.GenericMapper;
import com.vnpt.eoffice.controller.request.VanBanRequest;
import com.vnpt.eoffice.controller.response.ResponseBody;
import com.vnpt.eoffice.domain.Status;
import com.vnpt.eoffice.domain.VanBan;
import com.vnpt.eoffice.dto.VanBanDto;
import com.vnpt.eoffice.exception.ValidateException;
import com.vnpt.eoffice.repository.IDonViChucNangRepository;
import com.vnpt.eoffice.repository.LoaiVanBanRepo;
import com.vnpt.eoffice.repository.VanBanRepository;
import com.vnpt.eoffice.util.Const;
import com.vnpt.eoffice.util.DateFormatter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/van-ban")
@RequiredArgsConstructor
public class VanBanController {
    @Autowired
    GenericMapper genericMapper;

    @Autowired
    LoaiVanBanRepo loaiVanBanRepo;

    @Autowired
    VanBanRepository vanBanRepository;
    @Autowired
    IDonViChucNangRepository iDonViChucNangRepository;

    @PostMapping("")
    public ResponseEntity<ResponseBody> create(@Valid @RequestBody VanBanRequest.Create vanBan) throws ValidateException {
        Integer idUser = Integer.valueOf((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        VanBan vanBanEntity = genericMapper.mapToType(vanBan, VanBan.class);
        vanBanEntity.setIdNguoiTao(idUser);
        vanBanEntity.setLoaiVanBan(loaiVanBanRepo.findById(vanBan.getIdLoaiVanBan()).orElse(null));
        vanBanEntity.setNgayTao(Timestamp.from(Instant.now()));
        vanBanEntity.setIsExist(Const.EXIST);
        vanBanEntity.setDonvichucnang(iDonViChucNangRepository.findById(vanBan.getIdDonvichucnang()).orElse(null));
        vanBanRepository.save(vanBanEntity);
        return ResponseEntity.ok(ResponseBody.ofSuccess());
    }

    @PutMapping("update/{idVanBan}")
    public ResponseEntity<ResponseBody> update(@PathVariable("idVanBan") Integer idVanBan,@Valid @RequestBody VanBanRequest.Update vanBanRequest) throws ValidateException {
        Optional<VanBan> vanBanOptional = vanBanRepository.findById(idVanBan);
        if(!vanBanOptional.isPresent()){
            return ResponseEntity.ok(ResponseBody.ofFailure("Văn bản không tồn tại"));
        }

        VanBan vanBan=vanBanOptional.get();
        vanBan.setLoaiVanBan(loaiVanBanRepo.findById(vanBanRequest.getIdLoaiVanBan()).orElse(null));
        vanBan.setDonvichucnang(iDonViChucNangRepository.findById(vanBanRequest.getIdDonvichucnang()).orElse(null));
        vanBan.setTenVanBan(vanBan.getTenVanBan());
        vanBan.setNoiDungVanBan(vanBanRequest.getNoiDungVanBan());
        vanBanRepository.save(vanBan);
        return ResponseEntity.ok(ResponseBody.ofSuccess());
    }


    @PutMapping("submit/{idVanBan}")
    public ResponseEntity<ResponseBody> submit(@PathVariable("idVanBan") Integer idVanBan, @Valid @RequestBody VanBanRequest.Submit vanBanRequest) throws ValidateException {
        Optional<VanBan> vanBanOptional = vanBanRepository.findById(idVanBan);
        if(!vanBanOptional.isPresent()){
            return ResponseEntity.ok(ResponseBody.ofFailure("Văn bản không tồn tại"));
        }

        VanBan vanBan=vanBanOptional.get();
        if(!Objects.isNull(vanBanRequest.getNoiDungVanBan() )){
            vanBan.setNoiDungVanBan(vanBanRequest.getNoiDungVanBan());
        }
        vanBan.setStatus(Status.XEM_XET);
        vanBanRepository.save(vanBan);
        return ResponseEntity.ok(ResponseBody.ofSuccess());
    }

    @PutMapping("pheDuyet/{idVanBan}")
    public ResponseEntity<ResponseBody> pheDuyet(@PathVariable("idVanBan") Integer idVanBan) throws ValidateException {
        Integer idUser = Integer.valueOf((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Optional<VanBan> vanBanOptional = vanBanRepository.findById(idVanBan);
        if(!vanBanOptional.isPresent()){
            return ResponseEntity.ok(ResponseBody.ofFailure("Văn bản không tồn tại"));
        }

        VanBan vanBan=vanBanOptional.get();
       if(Status.PHE_DUYET.equals(vanBan.getStatus())){
           return ResponseEntity.ok(ResponseBody.ofFailure("Văn bản đã được phê duyệt trước đó"));
       }
        if(Status.SOAN_THAO.equals(vanBan.getStatus())){
            return ResponseEntity.ok(ResponseBody.ofFailure("Văn bản đang được soạn thảo"));
        }
        vanBan.setStatus(Status.PHE_DUYET);
        vanBan.setNguoiPheDuyet(idUser);
        vanBan.setNgayPheDyet(Timestamp.from(Instant.now()));
        vanBanRepository.save(vanBan);

        return ResponseEntity.ok(ResponseBody.ofSuccess());
    }

    @PutMapping("banHanh/{idVanBan}")
    public ResponseEntity<ResponseBody> banHanh(@PathVariable("idVanBan") Integer idVanBan) throws ValidateException {
        Integer idUser = Integer.valueOf((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Optional<VanBan> vanBanOptional = vanBanRepository.findById(idVanBan);
        if(!vanBanOptional.isPresent()){
            return ResponseEntity.ok(ResponseBody.ofFailure("Văn bản không tồn tại"));
        }

        VanBan vanBan=vanBanOptional.get();
        if(Status.BAN_HANH.equals(vanBan.getStatus())){
            return ResponseEntity.ok(ResponseBody.ofFailure("Văn bản đã được ban hành vào ngày "+
                    DateFormatter.formatSecondsToOnlyDate(vanBan.getNgayBanHanh().getTime()/1000)));
        }

        if(!Status.PHE_DUYET.equals(vanBan.getStatus())){
            return ResponseEntity.ok(ResponseBody.ofFailure("Văn bản chưa được phê duyệt"));
        }

        vanBan.setStatus(Status.BAN_HANH);
        vanBan.setNguoiPheDuyet(idUser);
        vanBan.setNgayPheDyet(Timestamp.from(Instant.now()));
        vanBanRepository.save(vanBan);

        return ResponseEntity.ok(ResponseBody.ofSuccess());
    }

    @DeleteMapping("{idVanBan}")
    public ResponseEntity<ResponseBody> delete(@PathVariable("idVanBan") Integer idVanBan) throws ValidateException {
        Optional<VanBan> vanBanOptional = vanBanRepository.findById(idVanBan);
        if(!vanBanOptional.isPresent()){
            return ResponseEntity.ok(ResponseBody.ofFailure("Văn bản không tồn tại"));
        }
        VanBan vanBan=vanBanOptional.get();
        if(Const.DELETE.equals(vanBan.getIsExist())){
            return ResponseEntity.ok(ResponseBody.ofFailure("Văn bản đã được xóa trước đó"));
        }
        vanBan.setIsExist(Const.DELETE);
        vanBan.setNgayXoa(Timestamp.from(Instant.now()));
        vanBanRepository.save(vanBan);
        return ResponseEntity.ok(ResponseBody.ofSuccess());
    }

    @GetMapping
    public ResponseEntity<ResponseBody> getAll(Pageable pageable){
        Page<VanBan> vanBans = vanBanRepository.findAll(pageable);
        List<VanBanDto> vanBanDtos = genericMapper.mapToListOfTypeNotNullProperty(vanBans.get().collect(Collectors.toList()), VanBanDto.class);
        return ResponseEntity.ok(ResponseBody.ofSuccess(vanBanDtos));
    }

    @GetMapping("{idVanBan}")
    public ResponseEntity<ResponseBody> getById(@PathVariable("idVanBan") Integer idVanBan){
        VanBan vanBan  = vanBanRepository.findById(idVanBan).orElse(null);
        return ResponseEntity.ok(ResponseBody.ofSuccess(vanBan));
    }

}
