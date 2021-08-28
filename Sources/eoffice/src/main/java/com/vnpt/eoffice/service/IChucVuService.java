package com.vnpt.eoffice.service;

import com.vnpt.eoffice.dto.ChucVuDTO;


import java.util.ArrayList;

public interface IChucVuService {
	public ArrayList<ChucVuDTO> getAll();

	void delete(Integer id);

	public ChucVuDTO getById(Integer id);

	ChucVuDTO update(ChucVuDTO t);

	ChucVuDTO insert(ChucVuDTO t);
}
