package p007b.p225i.p226a.p341g.p345d;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.google.android.material.C10817R;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;

/* compiled from: CalendarStyle.java */
/* renamed from: b.i.a.g.d.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class CalendarStyle {

    /* renamed from: a */
    @NonNull
    public final CalendarItemStyle f11584a;

    /* renamed from: b */
    @NonNull
    public final CalendarItemStyle f11585b;

    /* renamed from: c */
    @NonNull
    public final CalendarItemStyle f11586c;

    /* renamed from: d */
    @NonNull
    public final CalendarItemStyle f11587d;

    /* renamed from: e */
    @NonNull
    public final CalendarItemStyle f11588e;

    /* renamed from: f */
    @NonNull
    public final CalendarItemStyle f11589f;

    /* renamed from: g */
    @NonNull
    public final CalendarItemStyle f11590g;

    /* renamed from: h */
    @NonNull
    public final Paint f11591h;

    public CalendarStyle(@NonNull Context context) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(MaterialAttributes.resolveOrThrow(context, C10817R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), C10817R.styleable.MaterialCalendar);
        this.f11584a = CalendarItemStyle.m6058a(context, typedArrayObtainStyledAttributes.getResourceId(C10817R.styleable.MaterialCalendar_dayStyle, 0));
        this.f11590g = CalendarItemStyle.m6058a(context, typedArrayObtainStyledAttributes.getResourceId(C10817R.styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.f11585b = CalendarItemStyle.m6058a(context, typedArrayObtainStyledAttributes.getResourceId(C10817R.styleable.MaterialCalendar_daySelectedStyle, 0));
        this.f11586c = CalendarItemStyle.m6058a(context, typedArrayObtainStyledAttributes.getResourceId(C10817R.styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, C10817R.styleable.MaterialCalendar_rangeFillColor);
        this.f11587d = CalendarItemStyle.m6058a(context, typedArrayObtainStyledAttributes.getResourceId(C10817R.styleable.MaterialCalendar_yearStyle, 0));
        this.f11588e = CalendarItemStyle.m6058a(context, typedArrayObtainStyledAttributes.getResourceId(C10817R.styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.f11589f = CalendarItemStyle.m6058a(context, typedArrayObtainStyledAttributes.getResourceId(C10817R.styleable.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.f11591h = paint;
        paint.setColor(colorStateList.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
