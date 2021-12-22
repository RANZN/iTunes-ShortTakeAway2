package com.ranzan.shorttakeaway2.model.api

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName
import com.ranzan.shorttakeaway2.R

data class ResponseModel(

	@field:SerializedName("resultCount")
	val resultCount: Int? = null,

	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null
)

data class ResultsItem(

	@field:SerializedName("artworkUrl100")
	var artworkUrl100: String? = null,

	@field:SerializedName("trackTimeMillis")
	var trackTimeMillis: Int? = null,

	@field:SerializedName("country")
	var country: String? = null,

	@field:SerializedName("previewUrl")
	var previewUrl: String? = null,

	@field:SerializedName("artistId")
	var artistId: Int? = null,

	@field:SerializedName("trackName")
	var trackName: String? = null,

	@field:SerializedName("collectionName")
	var collectionName: String? = null,

	@field:SerializedName("artistViewUrl")
	var artistViewUrl: String? = null,

	@field:SerializedName("discNumber")
	var discNumber: Int? = null,

	@field:SerializedName("trackCount")
	var trackCount: Int? = null,

	@field:SerializedName("artworkUrl30")
	var artworkUrl30: String? = null,

	@field:SerializedName("wrapperType")
	var wrapperType: String? = null,

	@field:SerializedName("currency")
	var currency: String? = null,

	@field:SerializedName("collectionId")
	var collectionId: Int? = null,

	@field:SerializedName("isStreamable")
	var isStreamable: Boolean? = null,

	@field:SerializedName("trackExplicitness")
	var trackExplicitness: String? = null,

	@field:SerializedName("collectionViewUrl")
	var collectionViewUrl: String? = null,

	@field:SerializedName("trackNumber")
	var trackNumber: Int? = null,

	@field:SerializedName("releaseDate")
	var releaseDate: String? = null,

	@field:SerializedName("kind")
	var kind: String? = null,

	@field:SerializedName("trackId")
	var trackId: Int? = null,

	@field:SerializedName("collectionPrice")
	var collectionPrice: Double? = null,

	@field:SerializedName("discCount")
	var discCount: Int? = null,

	@field:SerializedName("primaryGenreName")
	var primaryGenreName: String? = null,

	@field:SerializedName("trackPrice")
	var trackPrice: Double? = null,

	@field:SerializedName("collectionExplicitness")
	var collectionExplicitness: String? = null,

	@field:SerializedName("trackViewUrl")
	var trackViewUrl: String? = null,

	@field:SerializedName("artworkUrl60")
	var artworkUrl60: String? = null,

	@field:SerializedName("trackCensoredName")
	var trackCensoredName: String? = null,

	@field:SerializedName("artistName")
	var artistName: String? = null,

	@field:SerializedName("collectionCensoredName")
	var collectionCensoredName: String? = null,

	@field:SerializedName("collectionArtistName")
	var collectionArtistName: String? = null,

	@field:SerializedName("contentAdvisoryRating")
	var contentAdvisoryRating: String? = null,

	@field:SerializedName("collectionArtistId")
	var collectionArtistId: Int? = null,

	)

@BindingAdapter("android:loadImage")
fun loadImage(imageView: ImageView, url: String) {
	Glide.with(imageView).load(url).placeholder(R.drawable.ic_baseline_broken_image_24)
		.into(imageView)
}