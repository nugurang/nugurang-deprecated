import React from 'react';

import ArticleDenseListWithLikeComment from '../../components/ArticleDenseListWithLikeComment';

export default function CompTest() {

const articles = [
  {
    id: 1,
    title: "Article 1",
    like: 1,
    comment: 3,
  },
  {
    id: 2,
    title: "Article 2",
    like: 2,
    comment: 6,
  },
  {
    id: 3,
    title: "Article 3",
    like: 3,
    comment: 9,
  }
];

  return (
	<div>
	  <ArticleDenseListWithLikeComment articles={articles} />
	</div>
  );
}
