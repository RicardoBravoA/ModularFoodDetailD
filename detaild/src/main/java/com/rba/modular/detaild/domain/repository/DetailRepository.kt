package com.rba.modular.detaild.domain.repository

import com.rba.modular.model.model.DetailModel
import com.rba.modular.model.model.ErrorModel
import com.rba.modular.util.domain.ResultType

interface DetailRepository {

    suspend fun getDetail(
        id: String
    ): ResultType<DetailModel, ErrorModel>

}