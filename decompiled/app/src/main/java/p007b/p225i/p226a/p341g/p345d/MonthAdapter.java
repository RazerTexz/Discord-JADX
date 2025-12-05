package p007b.p225i.p226a.p341g.p345d;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.C10817R;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateSelector;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import com.google.android.material.datepicker.Month;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MonthAdapter.java */
/* renamed from: b.i.a.g.d.g, reason: use source file name */
/* loaded from: classes3.dex */
public class MonthAdapter extends BaseAdapter {

    /* renamed from: j */
    public static final int f11606j = UtcDates.m6076i().getMaximum(4);

    /* renamed from: k */
    public final Month f11607k;

    /* renamed from: l */
    public final DateSelector<?> f11608l;

    /* renamed from: m */
    public Collection<Long> f11609m;

    /* renamed from: n */
    public CalendarStyle f11610n;

    /* renamed from: o */
    public final CalendarConstraints f11611o;

    public MonthAdapter(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints) {
        this.f11607k = month;
        this.f11608l = dateSelector;
        this.f11611o = calendarConstraints;
        this.f11609m = dateSelector.getSelectedDays();
    }

    /* renamed from: a */
    public int m6062a(int i) {
        return m6063b() + (i - 1);
    }

    /* renamed from: b */
    public int m6063b() {
        return this.f11607k.m9135j();
    }

    @Nullable
    /* renamed from: c */
    public Long m6064c(int i) {
        if (i < this.f11607k.m9135j() || i > m6065d()) {
            return null;
        }
        Month month = this.f11607k;
        return Long.valueOf(month.m9136k((i - month.m9135j()) + 1));
    }

    /* renamed from: d */
    public int m6065d() {
        return (this.f11607k.m9135j() + this.f11607k.f20988n) - 1;
    }

    /* renamed from: e */
    public final void m6066e(@Nullable TextView textView, long j) {
        CalendarItemStyle calendarItemStyle;
        if (textView == null) {
            return;
        }
        boolean z2 = false;
        if (this.f11611o.getDateValidator().isValid(j)) {
            textView.setEnabled(true);
            Iterator<Long> it = this.f11608l.getSelectedDays().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (UtcDates.m6068a(j) == UtcDates.m6068a(it.next().longValue())) {
                    z2 = true;
                    break;
                }
            }
            calendarItemStyle = z2 ? this.f11610n.f11585b : UtcDates.m6075h().getTimeInMillis() == j ? this.f11610n.f11586c : this.f11610n.f11584a;
        } else {
            textView.setEnabled(false);
            calendarItemStyle = this.f11610n.f11590g;
        }
        calendarItemStyle.m6059b(textView);
    }

    /* renamed from: f */
    public final void m6067f(MaterialCalendarGridView materialCalendarGridView, long j) {
        if (Month.m9132h(j).equals(this.f11607k)) {
            Calendar calendarM6071d = UtcDates.m6071d(this.f11607k.f20984j);
            calendarM6071d.setTimeInMillis(j);
            m6066e((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.m9130a().m6062a(calendarM6071d.get(5)) - materialCalendarGridView.getFirstVisiblePosition()), j);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return m6063b() + this.f11607k.f20988n;
    }

    @Override // android.widget.Adapter
    @Nullable
    public /* bridge */ /* synthetic */ Object getItem(int i) {
        return m6064c(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i / this.f11607k.f20987m;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00d5  */
    @Override // android.widget.Adapter
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, @Nullable View view, @NonNull ViewGroup viewGroup) {
        CharSequence charSequence;
        CharSequence charSequence2;
        Context context = viewGroup.getContext();
        if (this.f11610n == null) {
            this.f11610n = new CalendarStyle(context);
        }
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(C10817R.layout.mtrl_calendar_day, viewGroup, false);
        }
        int iM6063b = i - m6063b();
        if (iM6063b >= 0) {
            Month month = this.f11607k;
            if (iM6063b >= month.f20988n) {
                textView.setVisibility(8);
                textView.setEnabled(false);
            } else {
                int i2 = iM6063b + 1;
                textView.setTag(month);
                textView.setText(String.format(textView.getResources().getConfiguration().locale, "%d", Integer.valueOf(i2)));
                long jM9136k = this.f11607k.m9136k(i2);
                if (this.f11607k.f20986l == Month.m9133i().f20986l) {
                    Locale locale = Locale.getDefault();
                    if (Build.VERSION.SDK_INT >= 24) {
                        charSequence2 = UtcDates.m6070c("MMMEd", locale).format(new Date(jM9136k));
                    } else {
                        AtomicReference<TimeSource> atomicReference = UtcDates.f11617a;
                        DateFormat dateInstance = DateFormat.getDateInstance(0, locale);
                        dateInstance.setTimeZone(UtcDates.m6074g());
                        charSequence2 = dateInstance.format(new Date(jM9136k));
                    }
                    textView.setContentDescription(charSequence2);
                } else {
                    Locale locale2 = Locale.getDefault();
                    if (Build.VERSION.SDK_INT >= 24) {
                        charSequence = UtcDates.m6070c("yMMMEd", locale2).format(new Date(jM9136k));
                    } else {
                        AtomicReference<TimeSource> atomicReference2 = UtcDates.f11617a;
                        DateFormat dateInstance2 = DateFormat.getDateInstance(0, locale2);
                        dateInstance2.setTimeZone(UtcDates.m6074g());
                        charSequence = dateInstance2.format(new Date(jM9136k));
                    }
                    textView.setContentDescription(charSequence);
                }
                textView.setVisibility(0);
                textView.setEnabled(true);
            }
        }
        Long lM6064c = m6064c(i);
        if (lM6064c != null) {
            m6066e(textView, lM6064c.longValue());
        }
        return textView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}
