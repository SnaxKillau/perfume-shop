package kh.edu.rupp.ite.perfume_shop.api.model

data class ApiData<T> (
        val status: Status,
        val data: T?
    )

enum class Status {
        PROCESSING, SUCCESS, ERROR }

