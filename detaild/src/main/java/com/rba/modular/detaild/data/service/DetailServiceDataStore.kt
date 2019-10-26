package com.rba.modular.detaild.data.service

import com.rba.modular.detaild.data.api.ApiManager
import com.rba.modular.detaild.data.datastore.DetailDataStore
import com.rba.modular.detaild.data.util.RetrofitErrorUtil
import com.rba.modular.model.mapper.DetailMapper
import com.rba.modular.model.mapper.ErrorMapper
import com.rba.modular.model.model.DetailModel
import com.rba.modular.model.model.ErrorModel
import com.rba.modular.util.data.ErrorUtil
import com.rba.modular.util.domain.ResultType

class DetailServiceDataStore : DetailDataStore {

    override suspend fun getDetail(
        id: String
    ): ResultType<DetailModel, ErrorModel> {

        return try {
            val response = ApiManager.apiManager().restaurantDetail(id).await()
            if (response.isSuccessful) {
                val detailResponse = response.body()
                ResultType.Success(DetailMapper.transform(detailResponse!!))
            } else {
                val error = RetrofitErrorUtil.parseError(response)!!
                ResultType.Error(ErrorMapper.transform(error))
            }
        } catch (t: Throwable) {
            ResultType.Error(ErrorUtil.errorHandler(t))
        }

    }
}