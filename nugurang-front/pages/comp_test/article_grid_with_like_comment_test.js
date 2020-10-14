import React from 'react';

import ArticleGridWithLikeComment from '../../components/ArticleGridWithLikeComment';

export default function CompTest() {

const articles = [
  {
    id: 1,
    title: "Article 1",
    image: "/static/images/sample_1.jpg",
    like: 1,
    comment: 4,
  },
  {
    id: 2,
    title: "Article 2",
    image: "/static/images/sample_2.jpg",
    like: 2,
    comment: 9,
  },
  {
    id: 3,
    title: "Article 3",
    image: "/static/images/sample_3.jpg",
    like: 3,
    comment: 16,
  }
];

  return (
	<div>
	  <ArticleGridWithLikeComment articles={articles} />
	</div>
  );
}
