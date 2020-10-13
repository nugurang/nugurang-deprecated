import React from 'react';
import Chip from '@material-ui/core/Chip';

import ArticleListWithLikeComment from '../../components/ArticleListWithLikeComment';

export default function CompTest() {

const articles = [
  {
    id: 1,
    title: "Article 1",
    content: "Content 1",
    like: 1,
    comment: 3,
    image: "/static/images/sample_1.jpg",
    chip: <Chip label="Basic1" />,
  },
  {
    id: 2,
    title: "Article 2 with no images",
    content: "Content 2",
    like: 4,
    comment: 2,
    chip: <Chip label="Basic2" />,
  },
  {
    id: 3,
    title: "Article 3 with no chips",
    content: "Content 3",
    like: 9,
    image: "/static/images/sample_3.jpg",
    comment: 1,
  }
];

  return (
	<div>
	  <ArticleListWithLikeComment articles={articles} />
	</div>
  );
}
