package p007b.p225i.p226a.p341g.p345d;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.C10817R;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/* compiled from: DateFormatTextWatcher.java */
/* renamed from: b.i.a.g.d.c, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class DateFormatTextWatcher extends TextWatcherAdapter {

    /* renamed from: j */
    @NonNull
    public final TextInputLayout f11592j;

    /* renamed from: k */
    public final DateFormat f11593k;

    /* renamed from: l */
    public final CalendarConstraints f11594l;

    /* renamed from: m */
    public final String f11595m;

    /* renamed from: n */
    public final Runnable f11596n;

    /* renamed from: o */
    public Runnable f11597o;

    /* compiled from: DateFormatTextWatcher.java */
    /* renamed from: b.i.a.g.d.c$a */
    public class a implements Runnable {

        /* renamed from: j */
        public final /* synthetic */ String f11598j;

        public a(String str) {
            this.f11598j = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            DateFormatTextWatcher dateFormatTextWatcher = DateFormatTextWatcher.this;
            TextInputLayout textInputLayout = dateFormatTextWatcher.f11592j;
            DateFormat dateFormat = dateFormatTextWatcher.f11593k;
            Context context = textInputLayout.getContext();
            textInputLayout.setError(context.getString(C10817R.string.mtrl_picker_invalid_format) + "\n" + String.format(context.getString(C10817R.string.mtrl_picker_invalid_format_use), this.f11598j) + "\n" + String.format(context.getString(C10817R.string.mtrl_picker_invalid_format_example), dateFormat.format(new Date(UtcDates.m6075h().getTimeInMillis()))));
            DateFormatTextWatcher.this.mo6060a();
        }
    }

    public DateFormatTextWatcher(String str, DateFormat dateFormat, @NonNull TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.f11593k = dateFormat;
        this.f11592j = textInputLayout;
        this.f11594l = calendarConstraints;
        this.f11595m = textInputLayout.getContext().getString(C10817R.string.mtrl_picker_out_of_range);
        this.f11596n = new a(str);
    }

    /* renamed from: a */
    public abstract void mo6060a();

    /* renamed from: b */
    public abstract void mo6061b(@Nullable Long l);

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public void onTextChanged(@NonNull CharSequence charSequence, int i, int i2, int i3) {
        this.f11592j.removeCallbacks(this.f11596n);
        this.f11592j.removeCallbacks(this.f11597o);
        this.f11592j.setError(null);
        mo6061b(null);
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        try {
            Date date = this.f11593k.parse(charSequence.toString());
            this.f11592j.setError(null);
            long time = date.getTime();
            if (this.f11594l.getDateValidator().isValid(time) && this.f11594l.isWithinBounds(time)) {
                mo6061b(Long.valueOf(date.getTime()));
                return;
            }
            DateFormatTextWatcher2 dateFormatTextWatcher2 = new DateFormatTextWatcher2(this, time);
            this.f11597o = dateFormatTextWatcher2;
            this.f11592j.postDelayed(dateFormatTextWatcher2, 1000L);
        } catch (ParseException unused) {
            this.f11592j.postDelayed(this.f11596n, 1000L);
        }
    }
}
