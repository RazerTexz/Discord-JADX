package com.discord.utilities.embed;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.DrawableRes;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.message.attachment.MessageAttachment;
import com.discord.api.message.attachment.MessageAttachmentType;
import com.discord.api.message.embed.EmbedImage;
import com.discord.api.message.embed.EmbedProvider;
import com.discord.api.message.embed.EmbedThumbnail;
import com.discord.api.message.embed.EmbedType;
import com.discord.api.message.embed.EmbedVideo;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.embed.RenderableEmbedMedia;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.display.DisplayUtils;
import com.discord.utilities.string.StringUtils2;
import d0.Tuples;
import d0.a0.MathJVM;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;

/* compiled from: EmbedResourceUtils.kt */
/* loaded from: classes2.dex */
public final class EmbedResourceUtils {
    public static final String FILE_SCHEME = "res:///";
    public static final int MAX_IMAGE_SIZE = 1440;
    public static final EmbedResourceUtils INSTANCE = new EmbedResourceUtils();
    private static final int MAX_IMAGE_VIEW_HEIGHT_PX = DimenUtils.dpToPixels(320);
    private static final List<EmbedType> PLAYABLE_EMBED_TYPES = Collections2.listOf((Object[]) new EmbedType[]{EmbedType.VIDEO, EmbedType.GIFV});

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;

        static {
            MessageAttachmentType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[MessageAttachmentType.VIDEO.ordinal()] = 1;
            iArr[MessageAttachmentType.IMAGE.ordinal()] = 2;
            iArr[MessageAttachmentType.FILE.ordinal()] = 3;
            EmbedType.values();
            int[] iArr2 = new int[11];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[EmbedType.LINK.ordinal()] = 1;
            iArr2[EmbedType.HTML.ordinal()] = 2;
            EmbedType embedType = EmbedType.VIDEO;
            iArr2[embedType.ordinal()] = 3;
            EmbedType embedType2 = EmbedType.GIFV;
            iArr2[embedType2.ordinal()] = 4;
            iArr2[EmbedType.TWEET.ordinal()] = 5;
            EmbedType embedType3 = EmbedType.IMAGE;
            iArr2[embedType3.ordinal()] = 6;
            iArr2[EmbedType.ARTICLE.ordinal()] = 7;
            EmbedType.values();
            int[] iArr3 = new int[11];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[embedType2.ordinal()] = 1;
            iArr3[embedType3.ordinal()] = 2;
            iArr3[embedType.ordinal()] = 3;
            EmbedType.values();
            int[] iArr4 = new int[11];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[embedType3.ordinal()] = 1;
            iArr4[embedType2.ordinal()] = 2;
            EmbedType.values();
            int[] iArr5 = new int[11];
            $EnumSwitchMapping$4 = iArr5;
            iArr5[embedType2.ordinal()] = 1;
            iArr5[embedType3.ordinal()] = 2;
            EmbedType.values();
            int[] iArr6 = new int[11];
            $EnumSwitchMapping$5 = iArr6;
            iArr6[EmbedType.FILE.ordinal()] = 1;
            iArr6[embedType.ordinal()] = 2;
        }
    }

    private EmbedResourceUtils() {
    }

    public static /* synthetic */ Tuples2 calculateScaledSize$default(EmbedResourceUtils embedResourceUtils, int i, int i2, int i3, int i4, Resources resources, int i5, int i6, Object obj) {
        return embedResourceUtils.calculateScaledSize(i, i2, i3, i4, resources, (i6 & 32) != 0 ? 0 : i5);
    }

    private final RenderableEmbedMedia createFileRenderableMedia(String filename) {
        StringBuilder sbU = outline.U(FILE_SCHEME);
        sbU.append(getFileDrawable(filename));
        return new RenderableEmbedMedia(sbU.toString(), 30, 40);
    }

    public static /* synthetic */ List getPreviewUrls$default(EmbedResourceUtils embedResourceUtils, String str, int i, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z2 = true;
        }
        return embedResourceUtils.getPreviewUrls(str, i, i2, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Tuples2<Integer, Integer> calculateScaledSize(int actualWidth, int actualHeight, int maxWidth, int maxHeight, Resources resources, int minWidth) {
        Intrinsics3.checkNotNullParameter(resources, "resources");
        float f = resources.getDisplayMetrics().density;
        float f2 = actualWidth;
        float f3 = f * f2;
        float f4 = actualHeight;
        float f5 = f * f4;
        boolean z2 = f3 > ((float) (maxWidth / 2)) || f5 > ((float) (maxHeight / 2));
        boolean z3 = minWidth > 0 && actualWidth < minWidth;
        float f6 = actualHeight > 0 ? f2 / f4 : 0.0f;
        if (!z2) {
            if (!z3) {
                return Tuples.to(Integer.valueOf(MathJVM.roundToInt(f3)), Integer.valueOf(MathJVM.roundToInt(f5)));
            }
            float f7 = minWidth;
            float f8 = (f7 / f2) * f4;
            float f9 = maxHeight;
            if (f8 > f9) {
                float f10 = f9 / f8;
                f7 *= f10;
                f8 *= f10;
            }
            return Tuples.to(Integer.valueOf(MathJVM.roundToInt(f7)), Integer.valueOf(MathJVM.roundToInt(f8)));
        }
        boolean z4 = actualWidth > actualHeight;
        float f11 = z4 ? maxWidth : maxHeight * f6;
        float f12 = z4 ? maxWidth / f6 : maxHeight;
        if (z4) {
            float f13 = maxHeight;
            if (f12 > f13) {
                f11 *= f13 / f12;
                f12 = f13;
            } else if (!z4) {
                float f14 = maxWidth;
                if (f11 > f14) {
                    f12 *= f14 / f11;
                    f11 = f14;
                }
            }
        }
        return Tuples.to(Integer.valueOf(MathJVM.roundToInt(f11)), Integer.valueOf(MathJVM.roundToInt(f12)));
    }

    public final int computeMaximumImageWidthPx(Context context) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        return Math.min(1440, DisplayUtils.getScreenSize(context).width() - (resources.getDimensionPixelSize(R.dimen.uikit_guideline_chat) + resources.getDimensionPixelSize(R.dimen.chat_cell_horizontal_spacing_total)));
    }

    public final RenderableEmbedMedia createRenderableEmbedMediaFromAttachment(MessageAttachment attachment) {
        Intrinsics3.checkNotNullParameter(attachment, "attachment");
        int iOrdinal = attachment.e().ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            return new RenderableEmbedMedia(attachment.getProxyUrl(), attachment.getWidth(), attachment.getHeight());
        }
        if (iOrdinal == 2) {
            return createFileRenderableMedia(attachment.getFilename());
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String getExternalOpenUrl(MessageEmbed messageEmbed) {
        EmbedProvider provider;
        Intrinsics3.checkNotNullParameter(messageEmbed, "$this$getExternalOpenUrl");
        EmbedType type = messageEmbed.getType();
        if (type == null) {
            return null;
        }
        int iOrdinal = type.ordinal();
        if (iOrdinal != 2) {
            if (iOrdinal == 6 && (provider = messageEmbed.getProvider()) != null) {
                return provider.getUrl();
            }
            return null;
        }
        EmbedVideo video = messageEmbed.getVideo();
        if (video != null) {
            return video.getUrl();
        }
        return null;
    }

    @DrawableRes
    public final int getFileDrawable(String filename) {
        String strSubstringAfterLast;
        String str = "";
        if (filename != null && (strSubstringAfterLast = Strings4.substringAfterLast(filename, '.', "")) != null) {
            str = strSubstringAfterLast;
        }
        FileType fromExtension = FileType.INSTANCE.getFromExtension(str);
        return fromExtension != null ? fromExtension.getFileDrawable() : R.drawable.ic_file_unknown;
    }

    public final int getMAX_IMAGE_VIEW_HEIGHT_PX() {
        return MAX_IMAGE_VIEW_HEIGHT_PX;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final RenderableEmbedMedia getPreviewImage(MessageEmbed messageEmbed) {
        Intrinsics3.checkNotNullParameter(messageEmbed, "$this$getPreviewImage");
        EmbedType type = messageEmbed.getType();
        RenderableEmbedMedia renderableEmbedMedia = null;
        if (type != null) {
            int iOrdinal = type.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                EmbedThumbnail thumbnail = messageEmbed.getThumbnail();
                if (thumbnail != null) {
                    Intrinsics3.checkNotNullParameter(thumbnail, "$this$asRenderableEmbedMedia");
                    String proxyUrl = thumbnail.getProxyUrl();
                    if (proxyUrl == null) {
                        proxyUrl = thumbnail.getUrl();
                    }
                    renderableEmbedMedia = new RenderableEmbedMedia(proxyUrl, thumbnail.getWidth(), thumbnail.getHeight());
                }
            } else if (iOrdinal == 2) {
                EmbedThumbnail thumbnail2 = messageEmbed.getThumbnail();
                if (thumbnail2 != null) {
                    Intrinsics3.checkNotNullParameter(thumbnail2, "$this$asRenderableEmbedMedia");
                    String proxyUrl2 = thumbnail2.getProxyUrl();
                    if (proxyUrl2 == null) {
                        proxyUrl2 = thumbnail2.getUrl();
                    }
                    renderableEmbedMedia = new RenderableEmbedMedia(proxyUrl2, thumbnail2.getWidth(), thumbnail2.getHeight());
                } else {
                    EmbedVideo video = messageEmbed.getVideo();
                    if (video != null) {
                        Intrinsics3.checkNotNullParameter(video, "$this$asRenderableEmbedMedia");
                        String proxyUrl3 = video.getProxyUrl();
                        if (proxyUrl3 == null) {
                            proxyUrl3 = video.getUrl();
                        }
                        renderableEmbedMedia = new RenderableEmbedMedia(proxyUrl3, video.getWidth(), video.getHeight());
                    }
                }
            } else if (iOrdinal != 3) {
                if (iOrdinal != 4 && iOrdinal != 5) {
                    if (iOrdinal != 7) {
                        EmbedImage image = messageEmbed.getImage();
                        if (image != null) {
                            Intrinsics3.checkNotNullParameter(image, "$this$asRenderableEmbedMedia");
                            String proxyUrl4 = image.getProxyUrl();
                            if (proxyUrl4 == null) {
                                proxyUrl4 = image.getUrl();
                            }
                            renderableEmbedMedia = new RenderableEmbedMedia(proxyUrl4, image.getWidth(), image.getHeight());
                        }
                    }
                }
            }
        }
        return renderableEmbedMedia;
    }

    public final List<String> getPreviewUrls(String originalUrl, int width, int height, boolean shouldAnimate) {
        Intrinsics3.checkNotNullParameter(originalUrl, "originalUrl");
        String str = originalUrl + "?width=" + width + "&height=" + height;
        if (shouldAnimate && (StringsJVM.startsWith$default(originalUrl, FILE_SCHEME, false, 2, null) || StringsJVM.endsWith$default(originalUrl, ".gif", false, 2, null))) {
            return CollectionsJVM.listOf(str);
        }
        StringBuilder sbX = outline.X(str, "&format=");
        sbX.append(StringUtils2.getSTATIC_IMAGE_EXTENSION());
        return Collections2.listOf((Object[]) new String[]{sbX.toString(), str});
    }

    public final boolean isAnimated(MessageEmbed messageEmbed) {
        Intrinsics3.checkNotNullParameter(messageEmbed, "$this$isAnimated");
        EmbedType type = messageEmbed.getType();
        RenderableEmbedMedia previewImage = getPreviewImage(messageEmbed);
        return isAnimated(type, previewImage != null ? previewImage.url : null);
    }

    public final boolean isInlineEmbed(MessageEmbed messageEmbed) {
        EmbedType type;
        Intrinsics3.checkNotNullParameter(messageEmbed, "$this$isInlineEmbed");
        if ((getPreviewImage(messageEmbed) == null && messageEmbed.getVideo() == null) || (type = messageEmbed.getType()) == null) {
            return false;
        }
        int iOrdinal = type.ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            if (messageEmbed.getAuthor() != null || messageEmbed.getTitle() != null) {
                return false;
            }
        } else if (iOrdinal != 7) {
            return false;
        }
        return true;
    }

    public final boolean isPlayable(MessageEmbed messageEmbed) {
        Intrinsics3.checkNotNullParameter(messageEmbed, "$this$isPlayable");
        return _Collections.contains(PLAYABLE_EMBED_TYPES, messageEmbed.getType());
    }

    public final boolean isSimpleEmbed(MessageEmbed messageEmbed) {
        int iOrdinal;
        Intrinsics3.checkNotNullParameter(messageEmbed, "$this$isSimpleEmbed");
        EmbedType type = messageEmbed.getType();
        if (type != null && ((iOrdinal = type.ordinal()) == 1 || iOrdinal == 7)) {
            return isInlineEmbed(messageEmbed);
        }
        return false;
    }

    public final boolean isAnimated(EmbedType embedType, String previewImageUri) {
        if (embedType == null) {
            return false;
        }
        int iOrdinal = embedType.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal != 7) {
                return false;
            }
        } else {
            if (previewImageUri == null) {
                return false;
            }
            Locale locale = Locale.ROOT;
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
            String lowerCase = previewImageUri.toLowerCase(locale);
            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (lowerCase == null || !Strings4.contains$default((CharSequence) lowerCase, (CharSequence) ".gif", false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }
}
