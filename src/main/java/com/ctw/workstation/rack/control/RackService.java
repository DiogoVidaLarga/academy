package com.ctw.workstation.rack.control;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rack.entity.RackDTO;
import com.ctw.workstation.rack.entity.RackMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@ApplicationScoped
public class RackService {

    @Inject
    RackRepository rackRepository;

    public List<RackDTO> getAllRacks() {
        return rackRepository
                .listAll()
                .stream()
                .map(RackMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RackDTO getRackById(UUID id) {
        Rack rack = rackRepository.findById(id);
        return RackMapper.toDTO(rack);
    }

    @Transactional
    public RackDTO createRack(RackDTO dto) {
        Rack rack = RackMapper.toEntity(dto);
        rack.setDefaultLocation("Portugal");
        rack.setCreatedAt(java.time.LocalDateTime.now());
        rack.setModifiedAt(java.time.LocalDateTime.now());
        rackRepository.persist(rack);
        return RackMapper.toDTO(rack);
    }

    @Transactional
    public RackDTO updateRack(UUID id, RackDTO dto) {
        Rack rack = rackRepository.findById(id);
        if (rack == null) {
            return null;
        }
        rack.setSerialNumber(dto.getSerialNumber());
        rack.setStatus(dto.getStatus());
        rack.setTeamId(dto.getTeamId());
        return RackMapper.toDTO(rack);
    }

    @Transactional
    public boolean deleteRack(UUID id) {
        Rack rack = rackRepository.findById(id);
        if (rack == null) {
            return false;
        }
        rackRepository.delete(rack);
        return true;
    }
}
