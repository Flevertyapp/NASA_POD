package ru.example.nasa_pod.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.radiobutton.MaterialRadioButton
import ru.example.nasa_pod.databinding.SettingsFragmentBinding
import ru.example.nasa_pod.ui.MainActivity

class SettingsFragment : Fragment() {
    var _binding: SettingsFragmentBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = SettingsFragmentBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initThemeChooser()
        initButtons()
    }

    private fun initButtons() {
        binding.okButton.setOnClickListener {
            val activityMain = activity as MainActivity
            activityMain.apply {
                if (themeSaved != themeChoosen) {
                    themeSaved = themeChoosen
                    setAppTheme()
                }
                supportFragmentManager?.popBackStack()
            }
        }
        binding.cancelButton.setOnClickListener {
            val activityMain = activity as MainActivity
            activityMain.apply {
                if (themeSaved != themeChoosen) {
                    themeChoosen = themeSaved
                    setAppTheme()
                    recreate()
                    //TODO некорректно работает кнопка
                }
                supportFragmentManager?.popBackStack()
            }
        }
    }

    private fun initThemeChooser() {
        initRadioButtonListener(binding.mainTheme, MAIN_THEME)
        initRadioButtonListener(binding.redTheme, RED_THEME)
        with(binding.rbGroup.getChildAt(getMainActivity().themeChoosen!!) as MaterialRadioButton) {
            isChecked = true
        }
    }

    private fun getMainActivity(): MainActivity {
        return activity as MainActivity
    }

    private fun initRadioButtonListener(view: View, theme: Int) {
        view.setOnClickListener {
            val activityMain = activity as MainActivity
            activityMain.apply {
                themeChoosen = theme
                setAppTheme()
                recreate()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SettingsFragment()
    }
}