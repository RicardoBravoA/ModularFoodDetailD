package com.rba.modular.detaild.data.datastore

import com.rba.modular.model.model.DetailModel
import com.rba.modular.model.model.ErrorModel
import com.rba.modular.util.domain.ResultType

interface DetailDataStore {

    suspend fun getDetail(
        id: String
    ): ResultType<DetailModel, ErrorModel>

}