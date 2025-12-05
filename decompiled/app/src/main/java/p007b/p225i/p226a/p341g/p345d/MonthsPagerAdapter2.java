package p007b.p225i.p226a.p341g.p345d;

import android.view.View;
import android.widget.AdapterView;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import com.google.android.material.datepicker.MonthsPagerAdapter;
import com.google.android.material.datepicker.OnSelectionChangedListener;
import java.util.Iterator;

/* compiled from: MonthsPagerAdapter.java */
/* renamed from: b.i.a.g.d.h, reason: use source file name */
/* loaded from: classes3.dex */
public class MonthsPagerAdapter2 implements AdapterView.OnItemClickListener {

    /* renamed from: j */
    public final /* synthetic */ MaterialCalendarGridView f11612j;

    /* renamed from: k */
    public final /* synthetic */ MonthsPagerAdapter f11613k;

    public MonthsPagerAdapter2(MonthsPagerAdapter monthsPagerAdapter, MaterialCalendarGridView materialCalendarGridView) {
        this.f11613k = monthsPagerAdapter;
        this.f11612j = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        MonthAdapter monthAdapterM9130a = this.f11612j.m9130a();
        if (i >= monthAdapterM9130a.m6063b() && i <= monthAdapterM9130a.m6065d()) {
            MaterialCalendar.InterfaceC10896l interfaceC10896l = this.f11613k.f20994d;
            long jLongValue = this.f11612j.m9130a().m6064c(i).longValue();
            MaterialCalendar.C10888d c10888d = (MaterialCalendar.C10888d) interfaceC10896l;
            if (MaterialCalendar.access$100(MaterialCalendar.this).getDateValidator().isValid(jLongValue)) {
                MaterialCalendar.access$200(MaterialCalendar.this).select(jLongValue);
                Iterator it = MaterialCalendar.this.onSelectionChangedListeners.iterator();
                while (it.hasNext()) {
                    ((OnSelectionChangedListener) it.next()).onSelectionChanged(MaterialCalendar.access$200(MaterialCalendar.this).getSelection());
                }
                MaterialCalendar.access$000(MaterialCalendar.this).getAdapter().notifyDataSetChanged();
                if (MaterialCalendar.access$300(MaterialCalendar.this) != null) {
                    MaterialCalendar.access$300(MaterialCalendar.this).getAdapter().notifyDataSetChanged();
                }
            }
        }
    }
}
