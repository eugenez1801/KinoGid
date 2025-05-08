import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kinogid.GetRecommendationsUseCase
import com.example.kinogid.MainViewModel
import com.example.kinogid.Repository

class ViewModelFactory(
    private val repository: Repository,
    private val recommendationUseCase: GetRecommendationsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository, recommendationUseCase) as T
    }
}