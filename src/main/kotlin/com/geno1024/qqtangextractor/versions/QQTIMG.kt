package com.geno1024.qqtangextractor.versions

import com.geno1024.qqtangextractor.Settings
import com.geno1024.qqtangextractor.ds.ResourceTree
import java.io.File

object QQTIMG
{
    operator fun invoke()
    {
        File(Settings.version).mkdirs()


        File("${Settings.version}/README.md").writeText(ResourceTree.toTreeDiagramWithinZip())
    }
}
