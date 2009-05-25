package com.tamuvii.service;

import java.util.List;

import com.tamuvii.pojo.ShelfDirectorReport;

public interface ShelfManager {

	public List<ShelfDirectorReport> getShelfDirectorReport(String username);
}
