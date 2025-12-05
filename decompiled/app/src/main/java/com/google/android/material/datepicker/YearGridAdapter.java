package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.C10817R;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;
import p007b.p225i.p226a.p341g.p345d.CalendarItemStyle;
import p007b.p225i.p226a.p341g.p345d.CalendarStyle;
import p007b.p225i.p226a.p341g.p345d.UtcDates;
import p007b.p225i.p226a.p341g.p345d.YearGridAdapter2;

/* loaded from: classes3.dex */
public class YearGridAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a */
    public final MaterialCalendar<?> f21006a;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView textView;

        public ViewHolder(TextView textView) {
            super(textView);
            this.textView = textView;
        }
    }

    public YearGridAdapter(MaterialCalendar<?> materialCalendar) {
        this.f21006a = materialCalendar;
    }

    /* renamed from: a */
    public int m9142a(int i) {
        return i - this.f21006a.getCalendarConstraints().getStart().f20986l;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f21006a.getCalendarConstraints().getYearSpan();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        int i2 = this.f21006a.getCalendarConstraints().getStart().f20986l + i;
        String string = viewHolder2.textView.getContext().getString(C10817R.string.mtrl_picker_navigate_to_year_description);
        viewHolder2.textView.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i2)));
        viewHolder2.textView.setContentDescription(String.format(string, Integer.valueOf(i2)));
        CalendarStyle calendarStyle = this.f21006a.getCalendarStyle();
        Calendar calendarM6075h = UtcDates.m6075h();
        CalendarItemStyle calendarItemStyle = calendarM6075h.get(1) == i2 ? calendarStyle.f11589f : calendarStyle.f11587d;
        Iterator<Long> it = this.f21006a.getDateSelector().getSelectedDays().iterator();
        while (it.hasNext()) {
            calendarM6075h.setTimeInMillis(it.next().longValue());
            if (calendarM6075h.get(1) == i2) {
                calendarItemStyle = calendarStyle.f11588e;
            }
        }
        calendarItemStyle.m6059b(viewHolder2.textView);
        viewHolder2.textView.setOnClickListener(new YearGridAdapter2(this, i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(C10817R.layout.mtrl_calendar_year, viewGroup, false));
    }
}
