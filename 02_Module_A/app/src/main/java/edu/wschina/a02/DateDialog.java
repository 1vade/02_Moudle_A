package edu.wschina.a02;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import edu.wschina.a02.databinding.DialogDateBinding;

public class DateDialog extends DialogFragment {
	DialogDateBinding binding;
	
	@NonNull
	@Override
	public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
		binding = DialogDateBinding.inflate(getLayoutInflater());
		AlertDialog dialog = new AlertDialog.Builder(requireContext())
				.setView(binding.getRoot())
				.setCancelable(true)
				.create();
		return dialog;
	}
}
