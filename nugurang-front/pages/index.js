import React from 'react';
import AppBar from '@material-ui/core/AppBar';
import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import Container from '@material-ui/core/Container';
import CssBaseline from '@material-ui/core/CssBaseline';
import Grid from '@material-ui/core/Grid';
import InboxIcon from '@material-ui/icons/Inbox';
import Link from '@material-ui/core/Link';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemAvatar from '@material-ui/core/ListItemAvatar';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Typography from '@material-ui/core/Typography';
import StarsIcon from '@material-ui/icons/Stars';
import BottomNavBarLayout from '../components/BottomNavBarLayout';

const useStyles = makeStyles((theme) => ({
  paper_background: {
    alignItems: 'center',
    border: '0',
    display: 'flex',
    flexDirection: 'column',
    marginTop: theme.spacing(1),
    marginBottom: theme.spacing(10),
    padding: theme.spacing(1),
  }, 
  paper_card: {
    alignItems: 'center',
    display: 'flex',
    flexDirection: 'column',
    margin: theme.spacing(1),
    padding: theme.spacing(2),
    variant: 'outlined',
  },
  paper_list: {
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'left',
    variant: 'outlined',
    margin: theme.spacing(1),
    padding: theme.spacing(1),
  },
  typography_title: {
    margin: theme.spacing(2),
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: theme.palette.secondary.main,
  },
  button_more: {
    margin: theme.spacing(1),
  },
  card: {
    margin: theme.spacing(1),
  },
  card_title: {
    alignSelf: "end",
    textAlign: "center"
  },
  card_media_image_top: {
    height: 0,
    paddingTop: '56.25%', // 16:9
  },
  favicon: {
    height: 0,
    paddingTop: '100%', // 1:1
  }
}));


function ListItemLink(props) {
  return <ListItem button component="a" {...props} />;
}


const shortcutButtons = [
  {
    title: "Competition",
    image: "/static/images/competition.jpg"
  },
  {
    title: "Study",
    image: "/static/images/study.jpg"
  },
  {
    title: "Hobby",
    image: "/static/images/hobby.jpg"
  },
  {
    title: "Team",
    image: "/static/images/team.jpg"
  }
];

const hotArticles = [
  {
    primary: "Hot article 1",
    secondary: "1 likes"
  },
  {
    primary: "Hot article 2",
    secondary: "4 likes"
  },
  {
    primary: "Hot article 3",
    secondary: "9 likes"
  },
  {
    primary: "Hot article 4",
    secondary: "16 likes"
  }
];

const recentComps = [
  {
    title: "Comp 1",
    content: "Comp 1 content",
    image: "/static/images/article_01.jpg"
  },
  {
    title: "Comp 2",
    content: "Comp 2 content",
    image: "/static/images/article_02.jpg"
  },
  {
    title: "Comp 3",
    content: "Comp 3 content",
    image: "/static/images/article_03.jpg"
  },
  {
    title: "Comp 4",
    content: "Comp 4 content",
    image: "/static/images/article_04.jpg"
  }
];


function TopTitle() {
  const classes = useStyles();
  return (
    <Grid container spacing={2}>
      <Grid item xs={5} />
      <Grid item xs={2}>
        <CardMedia
          className={classes.favicon}
          image="/static/images/favicon.png"
          title="Contemplative Reptile"
        />
      </Grid>
      <Grid item xs={5} />
    </Grid>
  );
}

function ShortcutButtons() {
 const classes = useStyles();
  return (
    <Grid container spacing={2}>
      <Grid item xs={12}>
        <Grid container spacing={2}>

          {shortcutButtons.map(shortcutButton => (
            <Grid item xs={6} sm={3}>
              <Card variant="outlined">
                <CardActions>
                  <CardActionArea>
                    <CardMedia
                      className={classes.card_media_image_top}
                      image={shortcutButton.image}
                      title={shortcutButton.title}
                    />
                    <Typography align="center">
                      {shortcutButton.title}
                    </Typography>
                  </CardActionArea>
                </CardActions>
              </Card>
            </Grid>
          ))}

          <Grid item xs={12} align="right">
            <Button
              size="large"
              color="default"
              className={classes.button_more}
              startIcon={<StarsIcon />}
            >
              More
            </Button>
          </Grid>
        </Grid>
      </Grid>
    </Grid>
  );
}

function HotArticles() {
 const classes = useStyles();
  return (
    <Grid container spacing={2}>
      <Grid item xs={12}>
        <Typography className={classes.typography_title} component="h1" variant="h5">
          Hot articles
        </Typography>
        <Paper className={classes.paper_list} variant="outlined">
            <List>

              {hotArticles.map(hotArticle => (
                <>
                  <ListItem button>
                    <ListItemAvatar>
                      <Avatar>
                        <StarsIcon />
                      </Avatar>
                    </ListItemAvatar>
                    <ListItemText primary={hotArticle.primary} secondary={hotArticle.secondary} />
                  </ListItem>
                </>
              ))}

            </List>
        </Paper>
      </Grid>
    </Grid>
  );
}

function RecentComps() {
 const classes = useStyles();
  return (
    <Grid container spacing={2}>
      <Grid item xs={12}>
          <Grid container spacing={2}>
            <Grid item xs={12}>
            <Typography className={classes.typography_title} component="h1" variant="h5">
                Recent comps
              </Typography>
            </Grid>

            {recentComps.map(recentComp => (
              <Grid item xs={12} sm={6}>
                <Card className={classes.card} variant="outlined">
                  <CardActionArea>
                    <CardMedia
                      className={classes.card_media_image_top}
                      image={recentComp.image}
                      title={recentComp.title}
                    />
                    <CardContent>
                      <Typography gutterBottom variant="h5" component="h2">
                        {recentComp.title}
                      </Typography>
                      <Typography>
                        {recentComp.content}
                      </Typography>
                    </CardContent>
                    <CardActions>
                      <Button size="small" color="primary">
                        View
                      </Button>
                      <Button size="small" color="primary">
                        Star
                      </Button>
                    </CardActions>
                  </CardActionArea>
                </Card>
              </Grid>
            ))}

            <Grid item xs={12} align="right">
              <Button
                size="large"
                color="default"
                className={classes.button_more}
                startIcon={<StarsIcon />}
              >
                More
              </Button>

            </Grid>
          </Grid>
      </Grid>
    </Grid>
  );
}


export default function Home() {
  const classes = useStyles();
  return (
      <Container component="main" maxWidth="sm">
        <CssBaseline />
         <BottomNavBarLayout>
          <Paper className={classes.paper_background} variant="outlined">

            <Grid container spacing={2}>

              <Grid item xs={12}>
                <TopTitle />
              </Grid>

              <Grid item xs={12}>
                <Paper className={classes.paper_card} variant="outlined">
                  <ShortcutButtons />
                </Paper>
              </Grid>

              <Grid item xs={12}>
                <Paper className={classes.paper_card} variant="outlined">
                  <HotArticles />
                </Paper>
              </Grid>

              <Grid item xs={12}>
                <Paper className={classes.paper_card} variant="outlined">
                  <RecentComps />
                </Paper>
              </Grid>

            </Grid>
          </Paper>
        </BottomNavBarLayout>
      </Container>
  );
}
