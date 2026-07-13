package com.psiddhi.ivms.repository;

import java.util.HashMap;
import java.util.Map;

import com.psiddhi.ivms.model.Supplier;
import com.psiddhi.ivms.model.Finance;
import com.psiddhi.ivms.model.Performance;
import com.psiddhi.ivms.model.Contract;

public class VendorRepository {

    public static Map<String, Supplier> suppliers = new HashMap<>();

    public static Map<String, Finance> finances = new HashMap<>();

    public static Map<String, Performance> performances = new HashMap<>();

    public static Map<String, Contract> contracts = new HashMap<>();

}
