import React from 'react';
import { useRouter } from 'next/router';
import { gql, useQuery } from '@apollo/client';
import Grid from '@material-ui/core/Grid';

import Layout from '../../components/Layout';
import BaseButton from '../../components/BaseButton';
import BaseTabs from '../../components/BaseTabs';
import GraphQlError from '../../components/GraphQlError';
import ProjectInfoBox from '../../components/ProjectInfoBox';
import SectionBox from '../../components/SectionBox';
import SectionTitleBar from '../../components/SectionTitleBar';
import UserList from '../../components/UserList';
import WorkList from '../../components/WorkList';
import withAuth from '../../components/withAuth';
import Loading from '../../components/Loading';


const TAB_PROPS = [
  {
    id: 0,
    label: "Works",
  },
  {
    id: 1,
    label: "Teammates",
  },
]


const GET_PROJECT = gql`
  query getProject($id: ID!) {
    getProject(id: $id) {
      id
      name
      team {
        id
      }
      works {
        id
        name
      }
      event {
        id
      }
      getUsers(page: 0, pageSize: 100) {
        id
        name
        email
      }
    }
  }
`;

export default function ProjectInfo() {
  const router = useRouter();
  const responses = [
    useQuery(GET_PROJECT, {variables: {id: router.query.id}}),
  ];
  const errorResponse = responses.find((response) => response.error)
  if (errorResponse)
    return <GraphQlError error={errorResponse.error} />
  if (responses.some((response) => response.loading))
    return <Loading />;
  const project = responses[0].data ? responses[0].data.getProject : null;
  const users = responses[0].data.getTeam ? responses[0].data.getProject.getUsers : null;

  return (
    <Layout>

      <SectionTitleBar title="Project info" backButton="true" backButtonLink={`/teams/${project.team.id}`}>
        <BaseButton label="Create work" onClick={() => router.push({pathname: "/works/create", query: { project: router.query.id }})} />
      </SectionTitleBar>
      <SectionBox border={false}>
        <>
          <Grid item xs={12}>
            <ProjectInfoBox project={project} />
          </Grid>
        </>
      </SectionBox>


      <BaseTabs tabProps={TAB_PROPS}>
        <WorkList
          items={project.works}
        />
        <UserList
          items={users}
          link="/user"
        />
      </BaseTabs>


    </Layout>
  );
}