package com.vnpt.eoffice.controller.api;

import com.vnpt.eoffice.config.GenericMapper;
import com.vnpt.eoffice.controller.request.LoaiVanBanRequest;

import com.vnpt.eoffice.controller.response.ResponseBody;
import com.vnpt.eoffice.domain.LoaiVanBan;

import com.vnpt.eoffice.exception.ValidateException;
import com.vnpt.eoffice.repository.LoaiVanBanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/common/loaio-van-ban")
public class LoaiVanBanController {
    @Autowired
    LoaiVanBanRepo loaiVanBanRepo;


    @Autowired
    GenericMapper genericMapper;

    @PostMapping("")
    public ResponseEntity<ResponseBody> create(@Valid @RequestBody LoaiVanBanRequest loaiVanBanRequest) throws ValidateException {
        LoaiVanBan loaiVanBan = genericMapper.mapToType(loaiVanBanRequest, LoaiVanBan.class);
        try {
            loaiVanBanRepo.save(loaiVanBan);
        } catch (Exception exception) {
            return ResponseEntity.ok(ResponseBody.ofFailure("Tên văn bản đã tồn tại"));
        }
        return ResponseEntity.ok(ResponseBody.ofSuccess());
    }

    @PutMapping("{idLoaiVanBan}")
    public ResponseEntity<ResponseBody> update(@PathVariable("idLoaiVanBan") Integer idLoaiVanBan, @Valid @RequestBody LoaiVanBanRequest loaiVanBanRequest) throws ValidateException {
        Optional<LoaiVanBan> optionalLoaiVanBan = loaiVanBanRepo.findById(idLoaiVanBan);
        if (!optionalLoaiVanBan.isPresent()) {
            return ResponseEntity.ok(ResponseBody.ofFailure("Loại văn bản không tồn tại"));
        }

        LoaiVanBan loaiVanBan = optionalLoaiVanBan.get();
        loaiVanBan.setTen(loaiVanBanRequest.getTen());
        loaiVanBan.setMoTa(loaiVanBanRequest.getMoTa());
        loaiVanBan.setId(idLoaiVanBan);

        try {
            loaiVanBanRepo.save(loaiVanBan);
        } catch (Exception exception) {
            return ResponseEntity.ok(ResponseBody.ofFailure("Tên văn bản đã tồn tại"));
        }
        return ResponseEntity.ok(ResponseBody.ofSuccess());
    }

    @DeleteMapping("{idLoaiVanBan}")
    public ResponseEntity<ResponseBody> delete(@PathVariable("idLoaiVanBan") Integer idLoaiVanBan) throws ValidateException {
        Optional<LoaiVanBan> optionalLoaiVanBan = loaiVanBanRepo.findById(idLoaiVanBan);
        if (!optionalLoaiVanBan.isPresent()) {
            return ResponseEntity.ok(ResponseBody.ofFailure("Loại văn bản không tồn tại"));
        }
        loaiVanBanRepo.delete(optionalLoaiVanBan.get());
        return ResponseEntity.ok(ResponseBody.ofSuccess());
    }

    @GetMapping("{idLoaiVanBan}")
    public ResponseEntity<ResponseBody> getById(@PathVariable("idLoaiVanBan") Integer idLoaiVanBan) throws ValidateException {
        Optional<LoaiVanBan> optionalLoaiVanBan = loaiVanBanRepo.findById(idLoaiVanBan);
        if (!optionalLoaiVanBan.isPresent()) {
            return ResponseEntity.ok(ResponseBody.ofFailure("Loại văn bản không tồn tại"));
        }
        return ResponseEntity.ok(ResponseBody.ofSuccess(optionalLoaiVanBan.orElse(null)));
    }

    @GetMapping()
    public ResponseEntity<ResponseBody> getAll(Pageable pageable) throws ValidateException {
        Page<LoaiVanBan> all = loaiVanBanRepo.findAll(pageable);
        return ResponseEntity.ok(ResponseBody.ofSuccess(all.stream().collect(Collectors.toList())));
    }
}
