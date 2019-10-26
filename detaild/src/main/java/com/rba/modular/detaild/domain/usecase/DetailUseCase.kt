package com.rba.modular.detaild.domain.usecase

import com.rba.modular.detaild.domain.repository.DetailRepository
import com.rba.modular.model.model.DetailModel
import com.rba.modular.model.model.ErrorModel
import com.rba.modular.util.domain.ResultType

class DetailUseCase(private val detailRepository: DetailRepository) {

    suspend fun getDetail(
        id: String
    ): ResultType<DetailModel, ErrorModel> {
        return detailRepository.getDetail(id)
    }

}