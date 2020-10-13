import React from 'react';

import ArticleBox from '../../components/ArticleBox';

export default function CompTest() {

const article = {
  title: "Article title",
  subtitle: "Article subtitle",
  image: "/static/images/sample_1.jpg",
  content: "Article content using accordion",
};

  return (
	<div>
	  <ArticleBox article={article} />
	</div>
  );
}
