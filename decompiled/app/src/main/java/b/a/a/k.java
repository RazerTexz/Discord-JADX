package b.a.a;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.utilities.birthday.BirthdayHelper;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: DatePickerDialog.kt */
/* loaded from: classes.dex */
public final class k extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {a.d0(k.class, "binding", "getBinding()Lcom/discord/databinding/DialogDatePickerBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public Function1<? super Long, Unit> onDatePicked;

    /* renamed from: m, reason: from kotlin metadata */
    public long selectedDate;

    /* renamed from: n, reason: from kotlin metadata */
    public boolean datePicked;

    /* renamed from: o, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: DatePickerDialog.kt */
    /* renamed from: b.a.a.k$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final k a(FragmentManager fragmentManager, CharSequence charSequence, long j, long j2) {
            d0.z.d.m.checkNotNullParameter(fragmentManager, "fragmentManager");
            d0.z.d.m.checkNotNullParameter(charSequence, "label");
            k kVar = new k();
            Bundle bundle = new Bundle();
            bundle.putCharSequence("label", charSequence);
            bundle.putLong("initial_date", j);
            bundle.putLong("max_date", j2);
            kVar.setArguments(bundle);
            kVar.show(fragmentManager, k.class.getName());
            return kVar;
        }
    }

    /* compiled from: DatePickerDialog.kt */
    public static final /* synthetic */ class b extends d0.z.d.k implements Function1<View, b.a.i.k> {
        public static final b j = new b();

        public b() {
            super(1, b.a.i.k.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/DialogDatePickerBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public b.a.i.k invoke(View view) {
            View view2 = view;
            d0.z.d.m.checkNotNullParameter(view2, "p1");
            int i = R.id.dialog_date_picker_done;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.dialog_date_picker_done);
            if (materialButton != null) {
                i = R.id.dialog_date_picker_input;
                DatePicker datePicker = (DatePicker) view2.findViewById(R.id.dialog_date_picker_input);
                if (datePicker != null) {
                    i = R.id.dialog_date_picker_title;
                    TextView textView = (TextView) view2.findViewById(R.id.dialog_date_picker_title);
                    if (textView != null) {
                        return new b.a.i.k((LinearLayout) view2, materialButton, datePicker, textView);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: DatePickerDialog.kt */
    public static final class c implements DatePicker.OnDateChangedListener {
        public c() {
        }

        @Override // android.widget.DatePicker.OnDateChangedListener
        public final void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(i, i2, i3);
            k kVar = k.this;
            d0.z.d.m.checkNotNullExpressionValue(calendar, "cal");
            kVar.selectedDate = calendar.getTimeInMillis();
            k kVar2 = k.this;
            kVar2.datePicked = true;
            Function1<? super Long, Unit> function1 = kVar2.onDatePicked;
            if (function1 != null) {
                function1.invoke(Long.valueOf(kVar2.selectedDate));
            }
        }
    }

    /* compiled from: DatePickerDialog.kt */
    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1<? super Long, Unit> function1;
            k kVar = k.this;
            if (kVar.datePicked && (function1 = kVar.onDatePicked) != null) {
                function1.invoke(Long.valueOf(kVar.selectedDate));
            }
            k.this.dismiss();
        }
    }

    public k() {
        super(R.layout.dialog_date_picker);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, b.j, null, 2, null);
    }

    public final b.a.i.k g() {
        return (b.a.i.k) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        g().c.clearFocus();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        CharSequence charSequence;
        super.onViewBoundOrOnResume();
        TextView textView = g().d;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.dialogDatePickerTitle");
        Bundle arguments = getArguments();
        if (arguments == null || (charSequence = arguments.getCharSequence("label")) == null) {
            charSequence = "";
        }
        textView.setText(charSequence);
        DatePicker datePicker = g().c;
        d0.z.d.m.checkNotNullExpressionValue(datePicker, "binding.dialogDatePickerInput");
        Bundle arguments2 = getArguments();
        datePicker.setMaxDate(arguments2 != null ? arguments2.getLong("max_date") : 0L);
        DatePicker datePicker2 = g().c;
        d0.z.d.m.checkNotNullExpressionValue(datePicker2, "binding.dialogDatePickerInput");
        datePicker2.setMinDate(BirthdayHelper.INSTANCE.subtractYearsFromToday(150));
        Bundle arguments3 = getArguments();
        this.selectedDate = arguments3 != null ? arguments3.getLong("initial_date") : 0L;
        if (this.onDatePicked == null) {
            dismiss();
        }
        Calendar calendar = Calendar.getInstance();
        d0.z.d.m.checkNotNullExpressionValue(calendar, "calendar");
        calendar.setTimeInMillis(this.selectedDate);
        g().c.init(calendar.get(1), calendar.get(2), calendar.get(5), new c());
        g().f143b.setOnClickListener(new d());
    }
}
