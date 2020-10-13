import React from 'react';

import UserInfoBox from '../../components/UserInfoBox';

export default function CompTest() {

const user = {
  name: "Username",
  image: "/static/favicon/sample_1.jpg",
  statistics: "Statistics",
  bio: "Bio"
}

  return (
	<div>
	  <UserInfoBox user={user} />
	</div>
  );
}
