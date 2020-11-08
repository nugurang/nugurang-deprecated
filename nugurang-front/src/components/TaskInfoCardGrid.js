import React from 'react';
import Grid from '@material-ui/core/Grid';
import 'array-flat-polyfill';

import NoContentsBox from './NoContentsBox';
import UserGroupInfoCard from './UserGroupInfoCard';


export default function TaskInfoCardGrid({ items, link=null, xs=12, sm=null, md=null, lg=null, xl=null }) {
  return (
    <>
      {
        items && items.length > 0
        ? (
          <Grid container alignments="center" justify="flex-start">
            {[items].flat().map((item) => (
              <Grid item
                key={item.id}
                xs={xs || 12}
                sm={sm || xs || 12}
                md={md || sm || xs || 12}
                lg={lg || md || sm || xs || 12}
                xl={xl || lg || md || sm || xs || 12}
              >
                <UserGroupInfoCard
                  primary={item.name}
                  secondary={item.name}
                  title={item.title}
                  users={item.users}
                />
              </Grid>
          ))}
          </Grid>
        )
        : <NoContentsBox />
      }
    </>
  );
}