package edu.festu.ivankuznetsov.networkcomposeapp.di



import edu.festu.ivankuznetsov.networkcomposeapp.network.NetworkObject
import edu.festu.ivankuznetsov.networkcomposeapp.network.PostAPI
import edu.festu.ivankuznetsov.networkcomposeapp.repository.PostRepository
import edu.festu.ivankuznetsov.networkcomposeapp.repository.PostRepositoryImpl
import edu.festu.ivankuznetsov.networkcomposeapp.viewmodel.PostViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/*
* Koin для того, чтобы обеспечить работу VM с использованием PostRepository
* */
val postModule = module {
    single<PostRepository> {
        PostRepositoryImpl(NetworkObject.retrofit)
    }
    viewModel { PostViewModel(get()) }
}