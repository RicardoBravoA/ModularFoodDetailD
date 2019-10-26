package com.rba.modular.detaild.data.util

import com.rba.modular.detaild.data.api.ApiManager
import com.rba.modular.model.entity.response.ErrorResponse
import retrofit2.Response
import java.io.IOException

object RetrofitErrorUtil {
    fun parseError(response: Response<*>): ErrorResponse? {

        val converter = ApiManager.retrofit.responseBodyConverter<ErrorResponse>(
            ErrorResponse::class.java,
            arrayOfNulls<Annotation>(0)
        )

        val error: ErrorResponse

        try {
            error = converter.convert(response.errorBody()!!)!!
        } catch (e: IOException) {
            return ErrorResponse()
        }

        return error
    }
}