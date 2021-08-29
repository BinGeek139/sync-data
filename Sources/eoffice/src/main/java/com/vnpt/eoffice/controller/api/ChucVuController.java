package com.vnpt.eoffice.controller.api;

import com.google.gson.Gson;
import com.vnpt.eoffice.controller.listener.*;
import com.vnpt.eoffice.controller.response.ResponseBody;
import com.vnpt.eoffice.dto.ChucVuDTO;
import com.vnpt.eoffice.repository.IChucVuRepository;
import com.vnpt.eoffice.service.IChucVuService;
import com.vnpt.eoffice.util.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/common/chucVu")
public class ChucVuController {
	@Autowired
	private IChucVuService chucvu;

	@Autowired
	PublicData publicData;

	@RequestMapping(value = "/delete/{pK}", method = RequestMethod.DELETE)
	public ResponseEntity<ResponseBody> delete(@PathVariable Integer pK) {
		chucvu.delete(pK);
		publicData.postForObject(new Message(
				ApiSynchronized.CHUC_VU_DELETE.name(),
				Const.CURRENT_SERVICE_NAME,
				pK
		));
		return ResponseEntity.ok(ResponseBody.ofSuccess());
	}

	@PostMapping("/update")
	public ResponseEntity<ResponseBody> update(@RequestBody ChucVuDTO lhd)
			throws SQLException {
		chucvu.update(lhd);
		publicData.postForObject(new Message(
				ApiSynchronized.CHUC_VU_UPDATE.name(),
				Const.CURRENT_SERVICE_NAME,
				lhd
		));
		 return ResponseEntity.ok(ResponseBody.ofSuccess());
	}

	@PostMapping("/add")
	public ResponseEntity<ResponseBody> insert(@RequestBody ChucVuDTO cv) {
		chucvu.insert(cv);
		publicData.postForObject(new Message(
				ApiSynchronized.CHUC_VU_CREATE.name(),
				Const.CURRENT_SERVICE_NAME,
				cv
		));
		 return ResponseEntity.ok(ResponseBody.ofSuccess());
	}
	@Autowired
	IChucVuRepository iChucVuRepository;

	@GetMapping
	public ResponseEntity<ResponseBody> getAll(){
		return  ResponseEntity.ok(ResponseBody.ofSuccess(iChucVuRepository.findAll()));
	}

}
