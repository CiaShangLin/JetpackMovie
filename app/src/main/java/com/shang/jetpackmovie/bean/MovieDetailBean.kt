package com.shang.jetpackmovie.bean

/**
 * 電影詳細內頁
 *
 */
data class MovieDetailBean(
    val adult: Boolean?,
    val backdrop_path: String?,
    val belongs_to_collection: Any?,
    val budget: Int?,
    val genres: List<MovieGenreBean.Genre>?,
    val homepage: String?,
    val id: Int?,
    val imdb_id: String?,
    val original_language: String?,
    val original_title: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val production_companies: List<ProductionCompany>?,
    val production_countries: List<ProductionCountry>?,
    val release_date: String?,
    val revenue: Int?,
    val runtime: Int?,
    val spoken_languages: List<SpokenLanguage>?,
    val status: String?,
    val tagline: String?,
    val title: String?,
    val video: Boolean?,
    val vote_average: Double?,
    val vote_count: Int?,
) {

    data class ProductionCompany(
        val id: Int?,
        val logo_path: String?,
        val name: String?,
        val origin_country: String?,
    )

    data class ProductionCountry(
        val iso_3166_1: String?,
        val name: String?,
    )

    data class SpokenLanguage(
        val english_name: String?,
        val iso_639_1: String?,
        val name: String?,
    )
}
