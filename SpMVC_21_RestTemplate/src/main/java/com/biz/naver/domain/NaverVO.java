package com.biz.naver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class NaverVO {

	// 뉴스
	private String title;
	private String originallink;
	private String link;
	private String description;
	private String pubDate;

	// 영화
	private String image;		// ": "https://ssl.pstatic.net/imgmovie/mdi/mit110/1793/179353_P01_143247.jpg",
	private String subtitle;	// ": "Run, <b>BTS</b>",
	private String director;	// ": "이준희|김래영|박서희|유현지|",
	private String actor;		// ": "",
	private String userRating;	// ": "10.00"

	// 도서
	private String author;//": "김승현",
	private String price;//": "12800",
	private String discount;//": "11520",
	private String publisher;//": "주니어RHK",
	private String pubdate;//": "20191031",
	private String isbn;//": "8925567881 9788925567884",
}
