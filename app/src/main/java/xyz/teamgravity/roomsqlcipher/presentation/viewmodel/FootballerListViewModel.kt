package xyz.teamgravity.roomsqlcipher.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import xyz.teamgravity.roomsqlcipher.data.model.FootballerModel
import xyz.teamgravity.roomsqlcipher.data.repository.FootballerRepository
import javax.inject.Inject

@HiltViewModel
class FootballerListViewModel @Inject constructor(
    private val repository: FootballerRepository,
) : ViewModel() {

    var footballers by mutableStateOf(emptyList<FootballerModel>())
        private set

    init {
        observe()
    }

    fun onRandomTeam() {
        viewModelScope.launch(NonCancellable) {
            repository.replaceFootballers()
        }
    }

    private fun observe() {
        observeFootballers()
    }

    private fun observeFootballers() {
        viewModelScope.launch {
            repository.getFootballers().collectLatest { footballers ->
                this@FootballerListViewModel.footballers = footballers
            }
        }
    }
}