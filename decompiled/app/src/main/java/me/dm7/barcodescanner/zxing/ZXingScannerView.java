package me.dm7.barcodescanner.zxing;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p414e.BarcodeFormat;
import p007b.p225i.p414e.BinaryBitmap;
import p007b.p225i.p414e.DecodeHintType;
import p007b.p225i.p414e.InvertedLuminanceSource;
import p007b.p225i.p414e.MultiFormatReader;
import p007b.p225i.p414e.PlanarYUVLuminanceSource;
import p007b.p225i.p414e.p418n.HybridBinarizer;
import p596e0.p597a.p598a.p599a.BarcodeScannerView;
import p596e0.p597a.p598a.p599a.CameraPreview2;
import p596e0.p597a.p598a.p599a.ViewFinderView;

/* loaded from: classes3.dex */
public class ZXingScannerView extends BarcodeScannerView {

    /* renamed from: D */
    public static final List<BarcodeFormat> f27495D;

    /* renamed from: E */
    public MultiFormatReader f27496E;

    /* renamed from: F */
    public List<BarcodeFormat> f27497F;

    /* renamed from: G */
    public InterfaceC12927b f27498G;

    /* renamed from: me.dm7.barcodescanner.zxing.ZXingScannerView$a */
    public class RunnableC12926a implements Runnable {

        /* renamed from: j */
        public final /* synthetic */ Result f27499j;

        public RunnableC12926a(Result result) {
            this.f27499j = result;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZXingScannerView zXingScannerView = ZXingScannerView.this;
            InterfaceC12927b interfaceC12927b = zXingScannerView.f27498G;
            zXingScannerView.f27498G = null;
            CameraPreview2 cameraPreview2 = zXingScannerView.f25300k;
            if (cameraPreview2 != null) {
                cameraPreview2.m10099e();
            }
            if (interfaceC12927b != null) {
                interfaceC12927b.handleResult(this.f27499j);
            }
        }
    }

    /* renamed from: me.dm7.barcodescanner.zxing.ZXingScannerView$b */
    public interface InterfaceC12927b {
        void handleResult(Result result);
    }

    static {
        ArrayList arrayList = new ArrayList();
        f27495D = arrayList;
        arrayList.add(BarcodeFormat.AZTEC);
        arrayList.add(BarcodeFormat.CODABAR);
        arrayList.add(BarcodeFormat.CODE_39);
        arrayList.add(BarcodeFormat.CODE_93);
        arrayList.add(BarcodeFormat.CODE_128);
        arrayList.add(BarcodeFormat.DATA_MATRIX);
        arrayList.add(BarcodeFormat.EAN_8);
        arrayList.add(BarcodeFormat.EAN_13);
        arrayList.add(BarcodeFormat.ITF);
        arrayList.add(BarcodeFormat.MAXICODE);
        arrayList.add(BarcodeFormat.PDF_417);
        arrayList.add(BarcodeFormat.QR_CODE);
        arrayList.add(BarcodeFormat.RSS_14);
        arrayList.add(BarcodeFormat.RSS_EXPANDED);
        arrayList.add(BarcodeFormat.UPC_A);
        arrayList.add(BarcodeFormat.UPC_E);
        arrayList.add(BarcodeFormat.UPC_EAN_EXTENSION);
    }

    public ZXingScannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10953c();
    }

    /* renamed from: b */
    public PlanarYUVLuminanceSource m10952b(byte[] bArr, int i, int i2) {
        Rect rect;
        synchronized (this) {
            if (this.f25302m == null) {
                Rect framingRect = ((ViewFinderView) this.f25301l).getFramingRect();
                int width = this.f25301l.getWidth();
                int height = this.f25301l.getHeight();
                if (framingRect != null && width != 0 && height != 0) {
                    Rect rect2 = new Rect(framingRect);
                    if (i < width) {
                        rect2.left = (rect2.left * i) / width;
                        rect2.right = (rect2.right * i) / width;
                    }
                    if (i2 < height) {
                        rect2.top = (rect2.top * i2) / height;
                        rect2.bottom = (rect2.bottom * i2) / height;
                    }
                    this.f25302m = rect2;
                }
                rect = null;
            }
            rect = this.f25302m;
        }
        if (rect == null) {
            return null;
        }
        try {
            return new PlanarYUVLuminanceSource(bArr, i, i2, rect.left, rect.top, rect.width(), rect.height(), false);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    public final void m10953c() {
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        enumMap.put(DecodeHintType.POSSIBLE_FORMATS, getFormats());
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        this.f27496E = multiFormatReader;
        multiFormatReader.m6921c(enumMap);
    }

    public Collection<BarcodeFormat> getFormats() {
        List<BarcodeFormat> list = this.f27497F;
        return list == null ? f27495D : list;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        byte[] bArr2;
        Result resultM6920b;
        if (this.f27498G == null) {
            return;
        }
        try {
            Camera.Size previewSize = camera.getParameters().getPreviewSize();
            int i = previewSize.width;
            int i2 = previewSize.height;
            if (C3404f.m4332q0(getContext()) != 1) {
                bArr2 = bArr;
                int i3 = i;
                i = i2;
                i2 = i3;
            } else {
                int rotationCount = getRotationCount();
                if (rotationCount != 1 && rotationCount != 3) {
                    i = i2;
                    i2 = i;
                }
                Camera.Size previewSize2 = camera.getParameters().getPreviewSize();
                int i4 = previewSize2.width;
                int i5 = previewSize2.height;
                int rotationCount2 = getRotationCount();
                if (rotationCount2 != 1 && rotationCount2 != 3) {
                    int i6 = i;
                    i = i2;
                    i2 = i6;
                    bArr2 = bArr;
                    int i32 = i;
                    i = i2;
                    i2 = i32;
                }
                int i7 = i5;
                int i8 = 0;
                bArr2 = bArr;
                while (i8 < rotationCount2) {
                    byte[] bArr3 = new byte[bArr2.length];
                    for (int i9 = 0; i9 < i7; i9++) {
                        for (int i10 = 0; i10 < i4; i10++) {
                            bArr3[(((i10 * i7) + i7) - i9) - 1] = bArr2[(i9 * i4) + i10];
                        }
                    }
                    i8++;
                    bArr2 = bArr3;
                    int i11 = i7;
                    i7 = i4;
                    i4 = i11;
                }
            }
            PlanarYUVLuminanceSource planarYUVLuminanceSourceM10952b = m10952b(bArr2, i2, i);
            Result resultM6920b2 = null;
            if (planarYUVLuminanceSourceM10952b != null) {
                BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSourceM10952b));
                try {
                    MultiFormatReader multiFormatReader = this.f27496E;
                    if (multiFormatReader.f13189b == null) {
                        multiFormatReader.m6921c(null);
                    }
                    resultM6920b = multiFormatReader.m6920b(binaryBitmap);
                    this.f27496E.reset();
                } catch (ReaderException | ArrayIndexOutOfBoundsException | NullPointerException unused) {
                    this.f27496E.reset();
                    resultM6920b = null;
                } catch (Throwable th) {
                    throw th;
                }
                if (resultM6920b == null) {
                    BinaryBitmap binaryBitmap2 = new BinaryBitmap(new HybridBinarizer(new InvertedLuminanceSource(planarYUVLuminanceSourceM10952b)));
                    try {
                        MultiFormatReader multiFormatReader2 = this.f27496E;
                        if (multiFormatReader2.f13189b == null) {
                            multiFormatReader2.m6921c(null);
                        }
                        resultM6920b2 = multiFormatReader2.m6920b(binaryBitmap2);
                        this.f27496E.reset();
                    } catch (NotFoundException unused2) {
                    } finally {
                        this.f27496E.reset();
                    }
                } else {
                    resultM6920b2 = resultM6920b;
                }
            }
            if (resultM6920b2 != null) {
                new Handler(Looper.getMainLooper()).post(new RunnableC12926a(resultM6920b2));
            } else {
                camera.setOneShotPreviewCallback(this);
            }
        } catch (RuntimeException e) {
            Log.e("ZXingScannerView", e.toString(), e);
        }
    }

    public void setFormats(List<BarcodeFormat> list) {
        this.f27497F = list;
        m10953c();
    }

    public void setResultHandler(InterfaceC12927b interfaceC12927b) {
        this.f27498G = interfaceC12927b;
    }
}
