//
//  BirthdayApp.swift
//  Birthday
//
//  Created by Yixuan Dai on 06/05/2024.
//

import SwiftUI
import SwiftData

@main
struct BirthdayApp: App {
    var body: some Scene {
        WindowGroup {
            ContentView()
                .modelContainer(for: Friend.self)
        }
    }
}
