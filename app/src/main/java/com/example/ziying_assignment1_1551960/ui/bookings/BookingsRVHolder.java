package com.example.ziying_assignment1_1551960.ui.bookings;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ziying_assignment1_1551960.R;

public class BookingsRVHolder extends RecyclerView.ViewHolder {
    TextView tvServiceName, tvServiceCategory, tvStartDate, tvStartTime,tvPaid;

    public BookingsRVHolder(@NonNull View itemView) {
        super(itemView);
        tvServiceName = itemView.findViewById(R.id.tv_serviceName);
        tvServiceCategory = itemView.findViewById(R.id.tv_serviceCategory);
        tvStartDate = itemView.findViewById(R.id.tv_startDate);
        tvStartTime = itemView.findViewById(R.id.tv_startTime);
        tvPaid= itemView.findViewById(R.id.tv_paid);
    }
}
