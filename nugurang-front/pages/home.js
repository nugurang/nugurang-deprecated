import { gql, useQuery } from '@apollo/client';
import { useRouter } from 'next/router';
import FavoriteIcon from '@material-ui/icons/Favorite';
import HomeIcon from '@material-ui/icons/Home';
import NotificationsIcon from '@material-ui/icons/Notifications';
import PersonIcon from '@material-ui/icons/Person';
import TrendingUpIcon from '@material-ui/icons/TrendingUp';
import WhatshotIcon from '@material-ui/icons/Whatshot';

import { COMMON_BOARDS, EVENT_BOARDS } from '../src/config';
import BaseButton from '../components/BaseButton';
import BaseIconButton from '../components/BaseIconButton';
import GraphQlError from '../components/GraphQlError';
import Layout from '../components/Layout';
import Loading from '../components/Loading';
import SectionBox from '../components/SectionBox';
import SectionTitleBar from '../components/SectionTitleBar';
import ThreadGrid from '../components/ThreadGrid';
import ThreadList from '../components/ThreadList';
import withAuth from '../components/withAuth';

export const GET_CURRENT_USER = gql`
  query {
    currentUser {
      id
      name
      image {
        id
        address
      }
    }
  }
`;

const GET_THREADS = gql`
  query GetThreads($boardNames: [String]!) {
    getThreadsByBoardNames(boards: $boardNames, page: 0, pageSize: 5) {
      id
      name
      upCount
      commentCount
      user {
        name
        image {
          address
        }
      }
      firstArticle {
        images {
          address
        }
      }
    }
  }
`;

const GET_HOT_THREADS = gql`
  query GetHotThreads($boardNames: [String]!) {
    getHotThreadsByBoardNames(boards: $boardNames, page: 0, pageSize: 5) {
      id
      name
      upCount
      commentCount
      user {
        name
        image {
          address
        }
      }
      firstArticle {
        images {
          address
        }
      }
    }
  }
`;

function Home() {
  const router = useRouter();
  const responses = [
    useQuery(GET_CURRENT_USER),
    useQuery(GET_HOT_THREADS, {variables: {boardNames: COMMON_BOARDS}}),
    useQuery(GET_THREADS, {variables: {boardNames: EVENT_BOARDS}}),
  ];

  const errorResponse = responses.find((response) => response.error)
  if (errorResponse)
    return <GraphQlError error={errorResponse.error} />

  if (responses.some((response) => response.loading))
    return <Loading />;

  const currentUser = responses[0].data.currentUser;
  const hotThreads = responses[1].data.getHotThreadsByBoardNames;
  const recentEvents = responses[2].data.getThreadsByBoardNames;

  return (
    <Layout>
      <SectionTitleBar title="Home" icon=<HomeIcon />>
        <BaseIconButton icon=<NotificationsIcon onClick={() => router.push('/notifications')} /> />
        <BaseIconButton icon=<PersonIcon onClick={() => router.push('/user')} /> />
      </SectionTitleBar>

      <SectionBox
        titleBar={(
          <SectionTitleBar title="Starred threads" icon=<FavoriteIcon />>
            <BaseButton label="More" />
          </SectionTitleBar>
        )}
      >
        <ThreadList items={hotThreads} />
      </SectionBox>

      <SectionBox
        titleBar={(
          <SectionTitleBar title="Hot threads" icon=<WhatshotIcon />/>
        )}
      >
        <ThreadList items={hotThreads} />
      </SectionBox>

      <SectionBox
        titleBar={(
          <SectionTitleBar title="Recent events" icon=<TrendingUpIcon />/>
        )}
      >
        <ThreadGrid items={recentEvents} />
      </SectionBox>

    </Layout>
  );
}

export default withAuth(Home);
