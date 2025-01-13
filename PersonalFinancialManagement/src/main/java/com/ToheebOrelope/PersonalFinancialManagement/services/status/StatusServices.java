package com.ToheebOrelope.PersonalFinancialManagement.services.status;

import com.ToheebOrelope.PersonalFinancialManagement.dto.GraphDTO;
import com.ToheebOrelope.PersonalFinancialManagement.dto.StatusDTO;

public interface StatusServices {

    GraphDTO getChartData();

    StatusDTO getStatus();
}
