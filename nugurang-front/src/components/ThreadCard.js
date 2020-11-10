import React from 'react';
import { makeStyles } from '@material-ui/styles';
import Avatar from '@material-ui/core/Avatar';
import Box from '@material-ui/core/Box';
import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import Grid from '@material-ui/core/Grid';
import { useRouter } from 'next/router';
import Typography from '@material-ui/core/Typography';
import 'array-flat-polyfill';

import NoContentsBox from './NoContentsBox';
import StatCounterBox from './StatCounterBox';

const useStyles = makeStyles(() => ({
  cardMedia: {
    height: 0,
    paddingTop: '56.25%', // 16:9
  },
  singleLineEllipsis: {
    overflow: "hidden",
    textOverflow: "ellipsis",
    display: "-webkit-box",
    "-webkit-line-clamp": 1,
    "-webkit-box-orient": "vertical"
  },
  doubleLineEllipsis: {
    overflow: "hidden",
    textOverflow: "ellipsis",
    display: "-webkit-box",
    "-webkit-line-clamp": 2,
    "-webkit-box-orient": "vertical"
  },
}));

export default function ThreadCard({ thread }) {
  const classes = useStyles();
  const router = useRouter();
  return (
    <Card
      onClick={() => thread.onClick ? thread.onClick() : null}
      variant="outlined"
    >
      <CardActionArea>
        <Box display={thread.image ? "block" : "none"}>
          <CardMedia className={classes.cardMedia}
            image={thread.image}
            title={thread.imageTitle ? thread.imageTitle : null}
          />
        </Box>
        <CardContent>
          <Grid container spacing={1} alignItems="center">
            <Grid item>
              <Grid container spacing={1} alignItems="center" direction="row">
                <Grid item>
                  <Avatar
                    src={thread.user.image ? thread.user.image.address : null}
                    variant="circle"
                  />
                </Grid>
                <Grid item>
                  <Typography variant="body1" className={classes.singleLineEllipsis}>{thread.user.name}</Typography>
                </Grid>
              </Grid>
            </Grid>
            <Grid item>
              <Typography variant="h6" className={classes.doubleLineEllipsis}>{thread.name}</Typography>
            </Grid>
          </Grid>
          <Grid container justify="flex-end">
            <Grid item align="right">
              <StatCounterBox compact image={thread.image} upCount={thread.upCount} />
            </Grid>
          </Grid>
        </CardContent>
      </CardActionArea>
    </Card>
  );
}