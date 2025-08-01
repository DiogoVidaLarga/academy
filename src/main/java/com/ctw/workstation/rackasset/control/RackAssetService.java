package com.ctw.workstation.rackasset.control;

import com.ctw.workstation.rackasset.entity.RackAsset;
import com.ctw.workstation.rackasset.entity.RackAssetDTO;
import com.ctw.workstation.rackasset.entity.RackAssetMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class RackAssetService {

    @Inject
    RackAssetRepository rakAssetRepository;

    public List<RackAssetDTO> getAllRackAssets() {
        return rakAssetRepository
                .listAll()
                .stream()
                .map(RackAssetMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RackAssetDTO getRackAssetById(UUID id) {
        RackAsset asset = rakAssetRepository.findById(id);
        return RackAssetMapper.toDTO(asset);
    }

    @Transactional
    public RackAssetDTO createRackAsset(RackAssetDTO dto) {
        RackAsset asset = RackAssetMapper.toEntity(dto);
        rakAssetRepository.persist(asset);
        return RackAssetMapper.toDTO(asset);
    }

    @Transactional
    public RackAssetDTO updateRackAsset(UUID id, RackAssetDTO dto) {
        RackAsset asset = rakAssetRepository.findById(id);
        if (asset == null) {
            return null;
        }
        asset.setAssetTag(dto.getAssettag());
        asset.setRackId(dto.getRackId());
        return RackAssetMapper.toDTO(asset);
    }

    @Transactional
    public boolean deleteRackAsset(UUID id) {
        RackAsset asset = rakAssetRepository.findById(id);
        if (asset == null) {
            return false;
        }
        rakAssetRepository.delete(asset);
        return true;
    }
}
