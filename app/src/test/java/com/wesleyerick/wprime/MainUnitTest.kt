package com.wesleyerick.wprime

import androidx.lifecycle.Observer
import com.wesleyerick.wprime.api.ApiConst
import com.wesleyerick.wprime.api.ApiService
import com.wesleyerick.wprime.model.Banner
import com.wesleyerick.wprime.model.Banners
import com.wesleyerick.wprime.repository.MainRepository
import com.wesleyerick.wprime.util.mockBanners
import com.wesleyerick.wprime.util.mockList
import com.wesleyerick.wprime.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertNotNull


@RunWith(MockitoJUnitRunner::class)
class MainUnitTest {

//    @Before
//    fun setUp() {
//        MockitoAnnotations.initMocks(this)
//    }

//    @get:Rule
//    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var popularBannerListObserver: Observer<List<Banner>>

    private lateinit var viewModel: MainViewModel


    @Test
    fun popularMovies_isLoaded() = runBlocking{
           //Arrange
           val repository = MockRepository(
               api = Mockito.mock(ApiService::class.java),
               const = Mockito.mock(ApiConst::class.java)
           )
           viewModel = MainViewModel(repository)
           viewModel.popularMoviesList.observeForever(popularBannerListObserver)

           //Act
           val results = viewModel.getPopularMovies()

           // Assert
           assertNotNull(results, "test ====================")
           verify(results).equals(popularBannerListObserver)
//           verify(popularBannerListObserver).equals(mockList)
    }

    class MockRepository(api: ApiService, const: ApiConst): MainRepository(api, const) {

        override suspend fun getPopularMovies(): Response<Banners> {

            return Response.success(mockBanners)
//            return Response.error(404, ResponseBody.create(MediaType.parse("1"),"erro"))
        }
    }
}