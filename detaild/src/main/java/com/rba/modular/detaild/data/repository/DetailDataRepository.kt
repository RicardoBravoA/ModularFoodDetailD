package com.rba.modular.detaild.data.repository

import com.rba.modular.detaild.data.service.DetailServiceDataStore
import com.rba.modular.detaild.domain.repository.DetailRepository
import com.rba.modular.model.model.DetailModel
import com.rba.modular.model.model.ErrorModel
import com.rba.modular.util.domain.ResultType

class DetailDataRepository : DetailRepository {
    override suspend fun getDetail(
        id: String
    ): ResultType<DetailModel, ErrorModel> {
        val detailDataStore = DetailServiceDataStore()
        return detailDataStore.getDetail(id)
    }

}