import { gql, useMutation, } from '@apollo/client';
import { useRouter } from 'next/router';
import React, { useRef } from 'react'
import Box from '@material-ui/core/Box';
import Button from '@material-ui/core/Button';
import FormControl from '@material-ui/core/FormControl';
import Grid from '@material-ui/core/Grid';
import TextField from '@material-ui/core/TextField';
import GroupAddIcon from '@material-ui/icons/GroupAdd';

import Layout from '../../components/Layout';
import SectionBox from '../../components/SectionBox';
import SectionTitleBar from '../../components/SectionTitleBar';
import withAuth from '../../components/withAuth';

export const CREATE_WORK = gql`
  mutation createWork($project: ID!, $name: String!) {
    createWork (project: $project, name: $name) {
      id
    }
  }
`;

function CreateWork() {
  const router = useRouter();
  const newName = useRef(null);

  const [
    createWork,
    { loading: mutationLoading, error: mutationError },
  ] = useMutation(CREATE_WORK);

  function handleNewNameChange() {
    newName.current.focus();
  }

  return (
    <Layout>

      <SectionTitleBar title="Create new work" backButton />

      <SectionBox titleBar={<SectionTitleBar title="Add work name" icon=<GroupAddIcon /> />}>
        <Grid container spacing={2} alignItems="center" justify="space-between">
          <Grid item xs>
            <FormControl fullWidth variant="filled">
              <TextField
                inputProps={{ style: { fontFamily: "Ubuntu" } }}
                InputLabelProps={{ style: { fontFamily: "Ubuntu" } }}
                inputRef={newName}
                label="Enter work name"
                variant="outlined"
                onClick={handleNewNameChange}
              />
            </FormControl>
          </Grid>
          <Grid item xs={12}>
            <form
              onSubmit={async (e) => {
                e.preventDefault();
                const workRes = await createWork({ variables: {project: router.query.project, name: newName.current.value}});
                const workId = workRes.data.createWork.id;
                router.push(`/works/${workId}`);
              }}
            >
              <Box align="center">
                <Button type="submit">Submit</Button>
              </Box>
            </form>
          </Grid>
        </Grid>
      </SectionBox>
      {mutationLoading && <p>Loading...</p>}
      {mutationError && <p>Error :( Please try again</p>}

    </Layout>
  );
}

export default withAuth(CreateWork);