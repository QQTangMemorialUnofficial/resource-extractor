package com.geno1024.qqtangextractor.versions

import com.geno1024.qqtangextractor.Settings
import com.geno1024.qqtangextractor.copyTo
import com.geno1024.qqtangextractor.decode
import com.geno1024.qqtangextractor.decodeFiles
import com.geno1024.qqtangextractor.ds.ResourceTree
import java.io.File

object QQTang5211
{
    operator fun invoke()
    {
        "/map" decodeFiles "IMG"
        "/map/icon" decodeFiles "IMG"
        "/music" copyTo "/music"
        "/object/namecard" decodeFiles "IMG"
        "/object/ui/cursor/fight.gsa" decode "IMG"
        "/object/ui/login/img_logo.img" decode "IMG"
        "/res/uiRes/face" decodeFiles "IMG"
        "/res/uiRes/face/faces" decodeFiles "IMG"
        "/res/uiRes/face/faces/member" decodeFiles "IMG"
        "/res/uiRes/game" decodeFiles "IMG"
        "/res/uiRes/gameChat" decodeFiles "IMG"
        "/res/uiRes/icon/chatBg" decodeFiles "IMG"
        "/res/uiRes/icon/item" decodeFiles "IMG"
        "/res/uiRes/icon/light" decodeFiles "IMG"
        "/res/uiRes/icon/namecard" decodeFiles "IMG"
        "/res/uiRes/icon/npcIcon" decodeFiles "IMG"
        "/res/uiRes/icon/pet" decodeFiles "IMG"
        "/res/uiRes/icon/petItem" decodeFiles "IMG"
        "/res/uiRes/icon/platform" decodeFiles "IMG"
        "/res/uiRes/selRoom" decodeFiles "IMG"
        "/res/uiRes/selRoom/icon" decodeFiles "IMG"
        "/res/uiRes/selRoom/mapFilter" decodeFiles "IMG"
        "/res/uiRes/selRoom/recorder" decodeFiles "IMG"
//        "/res/uiRes/selRoom/room/num_player.img" decode "OTF"
        "/res/uiRes/selSect" decodeFiles "IMG"
        "/res/uiRes/shop" decodeFiles "IMG"
        "/sound" copyTo "/sound"
        File("${Settings.version}/README.md").writeText(ResourceTree.toTreeDiagram())
    }
}
