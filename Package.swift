// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorPluginWapay",
    platforms: [.iOS(.v14)],
    products: [
        .library(
            name: "CapacitorPluginWapay",
            targets: ["WeAlipayPluginPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", from: "7.0.0")
    ],
    targets: [
        .target(
            name: "WeAlipayPluginPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/WeAlipayPluginPlugin"),
        .testTarget(
            name: "WeAlipayPluginPluginTests",
            dependencies: ["WeAlipayPluginPlugin"],
            path: "ios/Tests/WeAlipayPluginPluginTests")
    ]
)