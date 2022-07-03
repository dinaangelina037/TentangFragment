package com.dina.tentangfragment.model

import com.google.gson.annotations.SerializedName

data class ResponseUser(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)