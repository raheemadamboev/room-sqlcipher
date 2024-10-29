package xyz.teamgravity.roomsqlcipher.presentation.screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.TopAppBarState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import xyz.teamgravity.roomsqlcipher.R
import xyz.teamgravity.roomsqlcipher.presentation.viewmodel.FootballerListViewModel

@Composable
fun FootballerListScreen(
    topAppBarState: TopAppBarState = rememberTopAppBarState(),
    topAppBarScroll: TopAppBarScrollBehavior = remember { TopAppBarDefaults.enterAlwaysScrollBehavior(state = topAppBarState) },
    viewmodel: FootballerListViewModel = hiltViewModel(),
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.my_team))
                },
                scrollBehavior = topAppBarScroll
            )
        },
        modifier = Modifier.nestedScroll(topAppBarScroll.nestedScrollConnection)
    ) { padding ->
        LazyColumn(contentPadding = padding) {
            item {
                Button(
                    onClick = viewmodel::onRandomTeam,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                ) {
                    Text(text = stringResource(id = R.string.new_team))
                }
            }
            items(viewmodel.footballers) { footballer ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(text = footballer.ranking.toString())
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = footballer.name,
                            modifier = Modifier.weight(1F)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(text = footballer.position.toString())
                    }
                }
            }
        }
    }
}