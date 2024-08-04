package com.iscoding.imagesdispatcher.presentation


import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
// that File  was for learning purposes
data class CounterState(val count: Int = 0)

sealed class CounterIntent {
    object Increment : CounterIntent()
    object Decrement : CounterIntent()
}

interface CounterStore : Store<CounterIntent, CounterState, Nothing>

class CounterStoreFactory(
    private val storeFactory: StoreFactory
) {
    fun create(): CounterStore =
        object : CounterStore, Store<CounterIntent, CounterState, Nothing> by storeFactory.create(
            name = "CounterStore",
            initialState = CounterState(),
            bootstrapper = SimpleBootstrapper(Unit),
            executorFactory = { CounterExecutor() },
            reducer = CounterReducer()
        ) {}

    private sealed class Result {
        object Increment : Result()
        object Decrement : Result()
    }

    private class CounterExecutor :
        CoroutineExecutor<CounterIntent, Unit, CounterState, Result, Nothing>() {
        override fun executeIntent(intent: CounterIntent, getState: () -> CounterState) {
            when (intent) {
                is CounterIntent.Increment -> dispatch(Result.Increment)
                is CounterIntent.Decrement -> dispatch(Result.Decrement)
            }
        }
    }

    private class CounterReducer : Reducer<CounterState, Result> {
        override fun CounterState.reduce(msg: Result): CounterState =
            when (msg) {
                is Result.Increment -> copy(count = count + 1)
                is Result.Decrement -> copy(count = count - 1)
            }
    }

}