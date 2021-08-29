package hrm.listener.impl;

import hrm.domain.repository.IDonViChucNangRepository;
import hrm.listener.HandlerListener;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteDonViChucNangHandlerListener extends HandlerListener<Integer> {
    @Autowired
    IDonViChucNangRepository iDonViChucNangRepository;
    @Override
    protected void execute(Integer integer) {
        iDonViChucNangRepository.delete(iDonViChucNangRepository.getOne(integer));
    }
}
