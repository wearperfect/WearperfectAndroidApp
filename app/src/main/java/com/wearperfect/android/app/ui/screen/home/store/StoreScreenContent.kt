package com.wearperfect.android.app.ui.screen.home.store

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.wearperfect.android.app.component.tab.PerfectScrollableTabRow
import com.wearperfect.android.app.component.tab.PerfectTab
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun StoreScreenContent(navController: NavHostController){

    var selectedTabIndexState = rememberPagerState(0)
    val scope = rememberCoroutineScope()

    val tabs = listOf(
        "Latest",
        "Collections",
        "Deals"
    )

    Column() {
        PerfectScrollableTabRow(
            selectedTabIndex = selectedTabIndexState.currentPage,
            divider = {},
            backgroundColor = MaterialTheme.colors.background,
            indicator = { tabPositions ->
                // on below line we are specifying the styling
                // for tab indicator by specifying height
                // and color for the tab indicator.
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(selectedTabIndexState, tabPositions),
                    height = 2.dp,
                    color = MaterialTheme.colors.onBackground
                )
            }
        ) {
            tabs.forEachIndexed { index, tab ->
                PerfectTab(
                    selected = selectedTabIndexState.currentPage == index,
                    onClick = {
                              scope.launch {
                                  selectedTabIndexState.animateScrollToPage(index)
                              }
                    },
                    text = { Text(text = tab, overflow = TextOverflow.Ellipsis) },
                )
            }
        }

        HorizontalPager(
            state = selectedTabIndexState,
            count = tabs.size
        ) { page ->
            when (page) {
                0 -> StoreLatestTabContent(navController)
                1 -> StoreCollectionsTabContent(navController)
                2 -> StoreDealsTabContent(navController)
            }
        }
    }
}
