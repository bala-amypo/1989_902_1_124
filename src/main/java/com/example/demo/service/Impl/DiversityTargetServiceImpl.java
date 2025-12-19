package com.example.demo.service.impl;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DiversityTargetRepository;
import com.example.demo.service.DiversityTargetService;

import java.util.List;

public class DiversityTargetServiceImpl implements DiversityTargetService {

    private final DiversityTargetRepository repository;

    public DiversityTargetServiceImpl(DiversityTargetRepository repository) {
        this.repository = repository;
    }

    @Override
    public DiversityTarget createTarget(DiversityTarget target) {
        if (target.getTargetPercentage() < 0 ||
            target.getTargetPercentage() > 100) {
            throw new BadRequestException("Invalid percentage");
        }
        return repository.save(target);
    }

    @Override
    public List<DiversityTarget> getTargetsByYear(int year) {
        return repository.findByTargetYear(year);
    }

    @Override
    public void deactivateTarget(Long id) {
        DiversityTarget target = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Target not found"));

        target.setActive(false);
        repository.save(target);
    }
}
